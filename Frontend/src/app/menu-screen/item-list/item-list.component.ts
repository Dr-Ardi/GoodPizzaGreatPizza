import { Component, Input, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuItemsComponent } from '../menu-items/menu-items.component';
import { Item } from '../../item/item';
import { ItemService } from '../../item/item.service';

@Component({
  selector: 'app-item-list',
  standalone: true,
  imports: [CommonModule, MenuItemsComponent ],
  templateUrl:'./item-list.component.html',
  styleUrl: './item-list.component.css'
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
