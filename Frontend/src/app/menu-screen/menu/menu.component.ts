import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemListComponent } from '../item-list/item-list.component';
import { ItemService } from '../../variables/item/item.service';
import { MenuBarComponent } from '../menu-bar/menu-bar.component';
import { BackComponent } from '../../tools/backButton/back.component';
import {MatTooltipModule} from '@angular/material/tooltip';


@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, ItemListComponent, MenuBarComponent, BackComponent, MatTooltipModule],
  templateUrl:'./menu.component.html',
  styleUrl: './menu.component.css'
})

export class MenuComponent {
  
  types: string[] = [];

  @Input('matTooltip') message: string ="swipe >";

  constructor(private itemService: ItemService) {}

  ngOnInit(): void {
    this.getEachType();
  }

  getEachType(): any {
    this.itemService.getEachType().subscribe(types => this.types = types);
  }
}
