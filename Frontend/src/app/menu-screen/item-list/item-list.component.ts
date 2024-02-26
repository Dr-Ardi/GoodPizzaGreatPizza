import { Component, Input, inject} from '@angular/core';
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
      <app-menu-items class="listItem" [item]="item" [type]="type"></app-menu-items>
    </div>
  `,
  styles: ``
})
export class ItemListComponent {

  itemList: Item[] = [];
  itemService: ItemService = inject(ItemService);
  
  @Input() type!: string;

  ngOnInit(): void{
    this.getAllItems();
  }

  getAllItems(): any {
    this.itemService.getAllItems().subscribe(itemList => this.itemList = itemList);
  }
  
}
