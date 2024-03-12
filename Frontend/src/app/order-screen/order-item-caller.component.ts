import { Component, Input, OnInit, inject } from '@angular/core';
import { Orders } from '../variables/orders/orders';
import { Item } from '../variables/item/item';
import { ItemService } from '../variables/item/item.service';
import { CommonModule } from '@angular/common';
import { OrderItemComponent } from './order-item/order-item.component';

@Component({
  selector: 'app-order-item-caller',
  standalone: true,
  imports: [CommonModule, OrderItemComponent],
  template: `
    <section class="item">

      <app-order-item id="ordering" *ngIf="!order.ordered" [item]="item" [order]="order" [type]="type">
      </app-order-item>

      <app-order-item id="ordered" *ngIf="order.ordered" [item]="item" [order]="order" [type]="type">
      </app-order-item>

    </section>
  `,
  styles: ``
})
export class OrderItemCallerComponent implements OnInit {

  @Input() order!: Orders;

  type!: string;
  item!: Item;
  itemService: ItemService = inject(ItemService);

  ngOnInit(): void {
    this.getItemByName(this.order.item_Name);
    this.setType(this.order.ordered);
  }

  getItemByName(name: string): void{
    if(name != null)
      this.itemService.getItemByName(name).subscribe((item:Item)=> this.item = item);
    else
      this.getItemByName(name);
  }

  setType(type: boolean): void{
    if(type)
      this.type = "orderedItem";
    else
      this.type = "orderItem";
  }
}
