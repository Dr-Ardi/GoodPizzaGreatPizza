import { Component, Input, OnInit, inject } from '@angular/core';
import { Item } from '../item/item';
import { CommonModule } from '@angular/common';
import { IngredientService } from '../ingredient.service';
import { FormsModule } from '@angular/forms'
import { Size } from '../size';
import { SizeService } from '../size.service';
import { CommentsComponent } from '../comments.component';

@Component({
  selector: 'app-selector',
  standalone: true,
  imports: [CommonModule, FormsModule, CommentsComponent],
  template: `
    <div class="selectors">
      <select *ngIf="sizable" name="size" id="selector">
        <option value="label" disabled selected>Choose Size:</option>
        <option *ngFor="let size of sizes" value="{{size.size}}">{{size.size}} (+{{size.cost}}$)</option>
      </select>

      <select *ngIf="meat" name="meat" id="selector">
        <option value="label" disabled selected>Add Meat:</option>
        <option value=""></option>
      </select>

      <select *ngIf="cheese" name="cheese" id="selector">
        <option value="label" disabled selected>Add Cheese:</option>
        <option value=""></option>
      </select>

      <select *ngIf="sauce" name="sauce" id="selector">
        <option value="label" disabled selected>Add Sauce:</option>
        <option value=""></option>
      </select>
      
      <select *ngIf="excluding" name="exclude" id="selector">
        <option value="label" disabled selected>Remove Ingredient:</option>
        <option *ngFor="let ingredient of ingredients" value="{{ingredient}}" (click)="removeIngredient('ingredient')">{{ingredient}}</option>
      </select>
    </div>

    <app-comments></app-comments>

    <p>Final Price: {{this.finalPrice}} $</p>
  `,
  styleUrl: './selector.component.css'
})
export class SelectorComponent implements OnInit {

  @Input() item !: Item;

  finalPrice : number = 0;

  sizes: Size[] = [];
  ingredientService: IngredientService = inject(IngredientService)
  sizeService: SizeService = inject(SizeService)

  sizable: boolean = false;
  meat: boolean = false;
  cheese: boolean = false;
  sauce: boolean = false;
  excluding: boolean = false;

  ingredients!: string;
  removedIngredients!: string;

  ngOnInit(): void {
      this.finalPrice += this.item.price;
      this.typeSetter(this.item);
      this.getIngredients(this.item.id);
      this.getSizesByType(this.item.type);
  }

  typeSetter(item: Item): void{

    if(item.type !== "Appetiser" && item.type !== "Pasta" && item.type !== "Bread" && item.type !== "Salad")
      this.sizable = true;

    if(item.type == 'Pizza')
      this.meat = true;

    if(item.type == 'Pizza' || item.type == 'Burger')
      this.cheese = true;

    if(item.type == 'Pizza' || item.type == 'Burger' || item.type == 'Fries' || item.name == 'Onion Rings')
      this.sauce = true;

    if(item.type == 'Pizza' || item.type == 'Burger' || item.type == 'Salad')
      this.excluding = true;
  }

  getIngredients(id: number): void{
    this.ingredientService.findIngredientsById(id).subscribe(
      ingredients => this.ingredients = ingredients);
  }

  removeIngredient(ingredient: string): void{
    this.removedIngredients += ingredient;
  }

  getSizesByType(type: string): void{
    this.sizeService.getSizesByType(type).subscribe(sizes => this.sizes = sizes);
  }
  
}
