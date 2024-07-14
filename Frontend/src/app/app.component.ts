import { Component, OnInit, Renderer2 } from '@angular/core';
import { CommonModule  } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import { TableService } from './variables/tables/table.service';
import { TableSelScreenComponent } from './table-sel-screen/table-sel-screen.component';
import { BackButtonDirective } from './tools/backButton/back-button.directive';
import { MsgWindowComponent } from './tools/msgWindow.component';


@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, HomeScreenComponent, RouterModule, MatDialogModule, TableSelScreenComponent, BackButtonDirective]
})
export class AppComponent implements OnInit{

  title = 'Good Pizza Great Pizza';
  tableMsg: any = localStorage.getItem("table");
  table!: any;
  
  constructor(private tableService: TableService, private notify: MatDialog, private renderer: Renderer2){}

  ngOnInit(): void {

    if(this.tableMsg === "0"){
      this.checkTable(window.location.pathname !== "/");
    }
    else{
      this.checkTable(window.location.pathname !== "/");
      var table = parseInt(this.tableMsg);
      this.table = "Table " + this.tableMsg;
      this.tableService.sit(table);
    }
  }

  checkTable(path: boolean): void{
    var table = localStorage.getItem("table") || "0";
    if(table === "0" && path)
      window.location.href = "/";
    if(table !== "0" && !path)
      window.location.href = "/home";
  }
  
  isNotInHome(): String{
    return window.location.pathname !== '/home' ? 'normBut' : 'inviBut';
  }

  isNotTable(): String{
    return window.location.pathname !== '/' ? 'topBar' : 'hideBar';
  }

  callWaiter(): void{
    var table = parseInt(this.tableMsg);
    var msg = this.tableService.callWaiter(table);
    this.notify.open(MsgWindowComponent, {data: msg});
  }

  private hintElement: HTMLElement | null = null;

  hint(event: MouseEvent, msg: string): void {
    this.hintElement = this.renderer.createElement('div');
    const text = this.renderer.createText(msg);

    this.renderer.appendChild(this.hintElement, text);
    this.renderer.addClass(this.hintElement, 'hint');

    const target = event.target as HTMLElement;
    const rect = target.getBoundingClientRect();
    this.renderer.setStyle(this.hintElement, 'top', `${rect.bottom + window.scrollY}px`);
    this.renderer.setStyle(this.hintElement, 'left', `${rect.left + window.scrollX}px`);
    this.renderer.appendChild(document.body, this.hintElement);
  }

  removeHint(): void {
    if (this.hintElement) {
      this.renderer.removeChild(document.body, this.hintElement);
      this.hintElement = null;
    }
  }
  
}
