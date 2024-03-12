import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { TableListComponent } from './tools/tableList.component';
import { WarningComponent } from './tools/warning.component';


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

  isNotInHome(): boolean{
    return (window.location.pathname != "/");
  }

  constructor(private tableList:MatDialog, private warning: MatDialog){}

  ngOnInit(): void {

    if(this.tableMsg == "0")
      this.tableMsg = "Choose a Table:";
    else
      this.tableMsg = "Table " + this.tableMsg;

    
    
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
          localStorage.setItem("table", "0")
          window.location.reload();
        }
      });

    }
  }

  
}
