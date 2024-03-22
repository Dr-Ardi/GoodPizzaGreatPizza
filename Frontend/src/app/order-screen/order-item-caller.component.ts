import { Component, Input, OnInit } from '@angular/core';
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

      <div *ngIf="order.item_Name !== 'Table Not Found'">
        <app-order-item id="ordering" *ngIf="!order.ordered" [item]="item" [order]="order" [type]="type">
        </app-order-item>

        <app-order-item id="ordered" *ngIf="order.ordered" [item]="item" [order]="order" [type]="type">
        </app-order-item>
      </div>
      <div *ngIf="order.item_Name == 'Table Not Found'">
        <p class="noOrder">You haven't ordered yet.</p>
      </div>
    </section>
  `,
  styles: `
    .noOrder{
      text-align: center;
      color: #ccc;
      margin-top: 40px;
      font-size: 20px;
    }
  `
})
export class OrderItemCallerComponent implements OnInit {

  @Input() order!: Orders;

  type!: string;
  item!: Item;

  constructor(private itemService: ItemService){}

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
