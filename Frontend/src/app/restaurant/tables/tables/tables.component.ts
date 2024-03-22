import { Component, Input, OnInit } from '@angular/core';
import { Table } from '../../../variables/tables/table';
import { TableService } from '../../../variables/tables/table.service';

@Component({
  selector: 'app-tables',
  standalone: true,
  imports: [],
  template: `
    <div class="{{this.checkTable()}}" (click)="uncallWaiter()"
    (dblclick)="tablePaid()" (mouseover)="checkOrder()" >
      <h2>Table {{table.table_Number}}</h2>
    </div>
  `,
  styleUrl: './tables.component.css'
})
export class TablesComponent implements OnInit {

  @Input() table !: Table;

  constructor(private tableSevice: TableService){}

  ngOnInit(): void {
  }

  checkTable(): string{
    if(!this.table.occupied)
      return "unoccupied";
    else if(this.table.waiter_Called)
      return "called";
    else if(this.table.finished)
      return "finished";
    else
      return "table";
  }

  checkOrder(): void{

  }

  tablePaid(): void{
    var msg = this.tableSevice.tablePaid(this.table.table_Number);
    window.location.reload();
  }

  uncallWaiter(): void{
    var msg = this.tableSevice.callWaiter(this.table.table_Number);
    window.location.reload();
  }
}
