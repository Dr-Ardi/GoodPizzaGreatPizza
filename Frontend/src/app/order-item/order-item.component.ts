import { Component, Input } from '@angular/core';
import { Orders } from '../variables/orders/orders';
import { PhotoComponent } from '../tools/photo/photo.component';

@Component({
  selector: 'app-order-item',
  standalone: true,
  imports: [PhotoComponent],
  templateUrl: './order-item.component.html',
  styleUrl: './order-item.component.css'
})
export class OrderItemComponent {

  @Input() order!: Orders;
}
