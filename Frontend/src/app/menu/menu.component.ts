import { Component, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemListComponent } from '../item-list/item-list.component';
import { Item } from '../item';
import { ItemService } from '../item.service';
// import { MenuItemsComponent } from '../menu-items/menu-items.component';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, ItemListComponent],
  templateUrl:'./menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  itemList: Item[] = [];
  itemService: ItemService = inject(ItemService);
  types: string[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.getAllItems();
    this.getEachType();
  }

  getAllItems(): any {
    this.itemService.getAllItems().subscribe(itemList => this.itemList = itemList);
  }

  getEachType(): any {
    this.itemService.getEachType().subscribe(types => this.types = types);
  }
}
