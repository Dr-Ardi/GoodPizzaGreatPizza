import { Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemListComponent } from '../item-list/item-list.component';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [CommonModule, ItemListComponent],
  templateUrl:'./menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  
}
