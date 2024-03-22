import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { IngredientService } from '../../variables/ingredients/ingredient.service';
import { PhotoComponent } from '../../tools/photo/photo.component';
import { DescComponent } from '../../tools/desc.component';


@Component({
  selector: 'app-menu-items',
  standalone: true,
  imports: [CommonModule, RouterModule, PhotoComponent, DescComponent],
  templateUrl:'./menu-items.component.html' ,
  styleUrl: './menu-items.component.css'
})
export class MenuItemsComponent implements OnInit{
  
  @Input() item!: Item;
  @Input() type!: string;

  constructor(private ingredientService: IngredientService){}

  ngOnInit(): void{
    this.checkType();
  }

  //For simplisity reasons
  checkType(): any{
    if (this.item.type == "Fries"){
      this.item.type = "Appetiser";
    }

    if (this.item.type == "Water"){
      this.item.type = "Soft Drink";
    }
      
  }

  
}
