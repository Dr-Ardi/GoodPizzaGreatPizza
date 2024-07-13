import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Orders } from '../../variables/orders/orders';
import { OrderItemCallerComponent } from '../order-item-caller.component';
import { OrderService } from '../../variables/orders/order.service';
import { FormsModule } from '@angular/forms';
import { TableService } from '../../variables/tables/table.service';
import { MatDialog } from '@angular/material/dialog';
import { MsgWindowComponent } from '../../tools/msgWindow.component';

@Component({
  selector: 'app-my-order',
  standalone: true,
  imports: [CommonModule, OrderItemCallerComponent, FormsModule],
  templateUrl: './my-order.component.html' ,
  styleUrl: './my-order.component.css'
})
export class MyOrderComponent implements OnInit{
  
  orders: Orders[] = [];

  paymentMethod: any = localStorage.getItem("payment") || "Cash";

  table: any = localStorage.getItem("table"); 
  finalPrice: number = 0;

  constructor(private orderService: OrderService, private tableService: TableService,
    public notify: MatDialog){}
  
  ngOnInit(): void {
    this.getOrdersByTable(this.table);
    this.orderService.getFinalPrice(this.table).subscribe((price: number) => {
      this.finalPrice = Number(price.toFixed(2));   
    })
  }

  getOrdersByTable(table: number): void{
    this.orderService.getOrdersByTable(table).subscribe(orders => this.orders = orders);
  }

  completeOrder(): void{
    this.orderService.completeOrder(this.table);
    window.location.reload();
  }

  selectPaymentMethod(): void{
    localStorage.setItem("payment", this.paymentMethod);
    this.tableService.selectPaymentMethod(this.table, this.paymentMethod);
  }

  finished(): void{
    var msg = this.tableService.finished(this.table);
    this.notify.open(MsgWindowComponent, {data: msg});
  } 
}
