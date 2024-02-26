import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { TableListComponent } from './tools/tableList.component';
import { WarningComponent } from './tools/warning.component';
import { NumComService } from './tools/communicators/num-com.service';


@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, HomeScreenComponent, RouterModule, MatDialogModule]
})
export class AppComponent implements OnInit {
  title = "GPGPFront";

  tableMsg: string = "Choose a Table:";

  constructor(private tableList:MatDialog, private warning: MatDialog,
              private tableCom: NumComService){}

  ngOnInit(): void {
      
  }

  openTableList(){
    if(this.tableMsg == "Choose a Table:"){
      var tables = this.tableList.open(TableListComponent);
      tables.afterClosed().subscribe(myTable => {this.tableMsg = myTable});
    }
    else{
      var warning = this.warning.open(WarningComponent);

      warning.afterClosed().subscribe(newMsg => {
        if(newMsg == 'Yes')
          this.tableMsg = "Choose a Table:";
      });

    }

    if(this.tableMsg != "Choose a Table:")
      this.tableCom.sendTable(this.tableMsg);
  }

  
}
