import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { TableService } from '../variables/tables/table.service';
import { MatDialog } from '@angular/material/dialog';
import { MsgWindowComponent } from '../tools/msgWindow.component';

@Component({
  selector: 'app-home-screen',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl:'./home-screen.component.html',
  styleUrl: './home-screen.component.css'
})
export class HomeScreenComponent implements OnInit{

  isTableChosen: boolean = true;

  table: any = localStorage.getItem("table") || 0;

  constructor(private tableService: TableService, public notify: MatDialog){}

  ngOnInit(): void {

    if(this.table == 0 || this.table == "0")
      this.isTableChosen = true;
    else
      this.isTableChosen = false;
  }

  callWaiter(): void{
    var msg = this.tableService.callWaiter(this.table);
    this.notify.open(MsgWindowComponent, {data: msg});
  }
}
