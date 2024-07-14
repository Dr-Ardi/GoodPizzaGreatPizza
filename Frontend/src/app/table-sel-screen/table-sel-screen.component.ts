import { Component } from '@angular/core';
import { TableListComponent } from '../tools/tableList.component';
import { MatDialog } from '@angular/material/dialog';
import { TableService } from '../variables/tables/table.service';
import { RouterLink } from '@angular/router';
import { CommonModule, Location } from '@angular/common';

@Component({
  selector: 'app-table-sel-screen',
  standalone: true,
  imports: [TableListComponent, RouterLink , CommonModule],
  templateUrl:'./table-sel-screen.component.html',
  styleUrl: './table-sel-screen.component.css'
})
export class TableSelScreenComponent {

  table: any = localStorage.getItem("table") || "0";

  constructor(private tableList:MatDialog, private location: Location, private tableService: TableService){}

  ngOnInit(): void {
    this.openedThroughLink();
  }

  openedThroughLink(): void{
    this.table = window.location.hash.substring(1) || "0";
    if (this.table != "0"){
      localStorage.setItem("table", this.table);
      this.location.replaceState(this.location.path().split('#')[0]);
      window.location.href = "/home";
    }
  }
    
  openTableList(){
    var tables = this.tableList.open(TableListComponent);
    tables.afterClosed().subscribe(myTable => {
      if(myTable != "0"){
        this.tableService.sit(this.table);
        localStorage.setItem("table", myTable)
        window.location.href = "/home";
      }
    });

  }
}
