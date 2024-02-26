import { Component, Input, OnInit, inject } from '@angular/core';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { IngredientService } from '../../variables/ingredient.service';
import { PhotoComponent } from '../../tools/photo/photo.component';
import { DescComponent } from '../../tools/desc.component';


@Component({
  selector: 'app-menu-items',
  standalone: true,
  imports: [CommonModule, RouterModule, RouterOutlet, PhotoComponent, DescComponent],
  templateUrl:'./menu-items.component.html' ,
  styleUrl: './menu-items.component.css'
})
export class MenuItemsComponent implements OnInit{

  ingredientService: IngredientService = inject(IngredientService);
  
  @Input() item!: Item;
  @Input() type!: string;

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
