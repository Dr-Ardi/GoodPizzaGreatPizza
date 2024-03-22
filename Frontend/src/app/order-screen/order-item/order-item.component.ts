import { Component, Input, OnInit } from '@angular/core';
import { PhotoComponent } from '../../tools/photo/photo.component';
import { Orders } from '../../variables/orders/orders';
import { Item } from '../../variables/item/item';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order-item',
  standalone: true,
  imports: [CommonModule, PhotoComponent, RouterModule],
  templateUrl: './order-item.component.html',
  styleUrl: './order-item.component.css'
})
export class OrderItemComponent implements OnInit{

  @Input() order!: Orders;
  @Input() item!: Item;
  @Input() type!: string;

  include!: string;
  exclude!: string;
  extra!: string;

  ngOnInit(): void {
    this.setIncEx(this.order);
  }

  setIncEx(order: Orders){
    
    if(order.included != "")
      this.include = "+ " + order.included;

    if(order.excluded != "")
      this.exclude = "- " + order.excluded;

    if(order.extra != "")
      this.extra = "( " + order.extra + " )";

  }
}
