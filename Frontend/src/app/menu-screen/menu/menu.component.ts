import { Component, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemListComponent } from '../item-list/item-list.component';
import { ItemService } from '../../item/item.service';
import { MenuBarComponent } from '../menu-bar/menu-bar.component';


@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, ItemListComponent, MenuBarComponent],
  templateUrl:'./menu.component.html',
  styleUrl: './menu.component.css'
})

export class MenuComponent {
  itemService: ItemService = inject(ItemService);
  types: string[] = [];

  constructor() {
  }

  ngOnInit(): void {
    this.getEachType();
  }

  getEachType(): any {
    this.itemService.getEachType().subscribe(types => this.types = types);
  }
}