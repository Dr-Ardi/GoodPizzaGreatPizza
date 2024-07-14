import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { TableService } from '../variables/tables/table.service';
import { MatDialog } from '@angular/material/dialog';
import { WarningComponent } from '../tools/warning.component';
import { OrderService } from '../variables/orders/order.service';

@Component({
  selector: 'app-home-screen',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl:'./home-screen.component.html',
  styleUrl: './home-screen.component.css'
})
export class HomeScreenComponent{

  table: any = localStorage.getItem("table") || "0";

  constructor(private tableService: TableService, 
              private orderService: OrderService, 
              private warning: MatDialog){}

  leaveTable(): void{
    var warning = this.warning.open(WarningComponent);

    warning.afterClosed().subscribe(newMsg => {
      if(newMsg == 'Yes'){
        this.tableService.unsit(this.table);
        this.tableService.leaveTable(this.table);
        this.orderService.deleteOrders(this.table).subscribe(
          response => {
            console.log('Order deleted successfully', response);
          },
          error => {
            console.error('Error deleting order', error);
          }
        );
        localStorage.setItem("table", "0");
        window.location.href = "/";
      }
    });
  }
}
