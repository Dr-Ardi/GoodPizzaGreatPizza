import { Component } from '@angular/core';
import { BackComponent } from '../tools/backButton/back.component';
import { CommonModule } from '@angular/common';
import { Orders } from '../variables/orders/orders';
import { OrderItemComponent } from '../order-item/order-item.component';

@Component({
  selector: 'app-my-order',
  standalone: true,
  imports: [BackComponent, CommonModule, OrderItemComponent],
  templateUrl: './my-order.component.html' ,
  styleUrl: './my-order.component.css'
})
export class MyOrderComponent {
  orders: Orders[] = [];
}
