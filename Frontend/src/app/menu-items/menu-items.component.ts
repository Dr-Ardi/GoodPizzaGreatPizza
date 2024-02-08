import { Component, Input } from '@angular/core';
import { Item } from '../item';


@Component({
  selector: 'app-menu-items',
  standalone: true,
  imports: [],
  templateUrl:'./menu-items.component.html' ,
  styleUrl: './menu-items.component.css'
})
export class MenuItemsComponent {
  ImageUrl = "schoolurl";
  @Input() item!: Item;
}
