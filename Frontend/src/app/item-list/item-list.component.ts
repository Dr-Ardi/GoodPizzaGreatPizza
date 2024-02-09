import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItemsComponent } from '../menu-items/menu-items.component';
import { Item } from '../item';

@Component({
  selector: 'app-item-list',
  standalone: true,
  imports: [CommonModule, MenuItemsComponent ],
  templateUrl:'./item-list.component.html',
  styleUrl: './item-list.component.css'
})
export class ItemListComponent {

  
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
