import { Component, OnInit } from '@angular/core';
import { CommonModule, Location  } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { TableListComponent } from './tools/tableList.component';
import { WarningComponent } from './tools/warning.component';
import { TableService } from './variables/tables/table.service';


@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, HomeScreenComponent, RouterModule, MatDialogModule]
})
export class AppComponent implements OnInit {
  
  title = "GPGPFront";

  tableMsg: any = localStorage.getItem("table");

  table!: string;
  
  constructor(private tableList:MatDialog, private warning: MatDialog,
              private location: Location, private tableService: TableService){}

  ngOnInit(): void {

    this.openedThroughLink();

    if(this.tableMsg == "0")
      this.tableMsg = "Choose a Table:";
    else{
      var table = parseInt(this.tableMsg);
      this.tableMsg = "Table " + this.tableMsg;
      var msg = this.tableService.sit(table);
    }
  }

  openedThroughLink(): void{
    this.table = window.location.hash.substring(1) || "0";
    if (this.table != "0"){
      localStorage.setItem("table", this.table);
      this.location.replaceState(this.location.path().split('#')[0]);
      window.location.reload();
    }
  }
  
  isNotInHome(): boolean{
    return (window.location.pathname != "/");
  }
  
  openTableList(){
    if(this.tableMsg == "Choose a Table:"){
      var tables = this.tableList.open(TableListComponent);
      tables.afterClosed().subscribe(myTable => {
        localStorage.setItem("table", myTable)
        window.location.reload();
      });
    }
    else{
      var warning = this.warning.open(WarningComponent);

      warning.afterClosed().subscribe(newMsg => {
        if(newMsg == 'Yes'){
          var table = parseInt(this.tableMsg.substring(5));
          var msg = this.tableService.unsit(table);
          localStorage.setItem("table", "0")
          window.location.reload();
        }
      });

    }
  }

  
}
