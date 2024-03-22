import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItemsComponent } from '../menu-items/menu-items.component';
import { Item } from '../../variables/item/item';
import { ItemService } from '../../variables/item/item.service';

@Component({
  selector: 'app-item-list',
  standalone: true,
  imports: [CommonModule, MenuItemsComponent ],
  template: `
      <div class="listItem" *ngFor="let item of itemList">
        <app-menu-items class="item" [item]="item" [type]="type"></app-menu-items>
      </div>
  `,
  styles: `
    .listItem{
      width: 20%;
      display: flex;
      justify-content: center;
      margin: 15px 2.5% 15px 2.5%;   
    }
    .item:hover{
      cursor: pointer;
    }
    
    @media (max-width: 1620px){
      .listItem{
        width: 28.3%;
      }
    }
    @media (max-width: 1190px){
      .listItem{
        width: 45%;
      }
    }
    @media (max-width: 810px){
      .listItem{
        width: 28.3%;
      }
    }
    @media (max-width: 660px){
      .listItem{
        width: 45%;
      }
    }
  `
})
export class ItemListComponent {

  @Input() type!: string;
  
  itemList: Item[] = [];

  constructor(private itemService: ItemService){}

  ngOnInit(): void{
    this.getItemsByType(this.type);
  }

  getItemsByType(type: string): any {
    if(type != "Fries" && type != "Water"){
      if(type == "Appetiser"){
        this.itemService.getItemsByType(type).subscribe(itemList => this.itemList = itemList);
        this.itemService.getItemsByType("Fries").subscribe(itemList => {
          var item = itemList.pop();
          if (item)
            this.itemList.push(item);
        });
      }
      else if(type == "Soft Drink"){
        this.itemService.getItemsByType(type).subscribe(itemList => this.itemList = itemList);
        this.itemService.getItemsByType("Water").subscribe(itemList => {
          var item = itemList.pop();
          if (item)
            this.itemList.push(item);
        });
      }
      else
        this.itemService.getItemsByType(type).subscribe(itemList => this.itemList = itemList);
    }
  }
  
}
