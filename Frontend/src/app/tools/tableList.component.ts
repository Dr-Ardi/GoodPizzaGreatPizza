import { Component, OnInit, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableService } from '../variables/tables/table.service';
import { MatDialogRef } from '@angular/material/dialog';
@Component({
  selector: 'app-tableList',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div id="all">
    <div id="tableList">
        <div id="titleCard">
            <p>Choose a table</p>
            <button id="close" (click)="closeTableList(0)">Close</button> 
        </div>
        <div class="table">
            <button class="tableSelector" *ngFor="let table of tables" (click)="closeTableList(table)">Table {{table}}</button>
        </div>
    </div>
    <div>
  `,
  styles: ` 

    ::-webkit-scrollbar {
        width: 0px;
    }

    #all{
        position: fixed;
        background-color: transparent;
        backdrop-filter: brightness(70%);
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        top: 0px;
        animation: fadeIn 0.3s ease-in-out forwards;
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
    #tableList{
        background-color: var(--shadow-color);
        border: solid 1px var(--shadow-color);
        width:400px;
        height: 600px;
        display: flex;
        overflow-x: scroll;
        flex-direction: column;
        top: 20%;
        left: 20%;
        right: auto;
        padding: 5px;
        border-radius: 5%;
    }

    #titleCard{
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin-bottom: 5px;
        border-bottom: solid 1px var(--border-color);
        padding: 5px;
    }
    #titleCard > p{
        font-size: calc(25px*1.618);
    }
    #close{
        border:0px;
        background-color: transparent;
        color: var(--primary-color);
        font-size: calc(25px/1.618);
    }
    .table{
        margin-top: 5px;
        display:flex;
        flex-direction: column;
        gap: 10px;
        width:100%;
        align-items: center;
    }
    .tableSelector{
        background-color: var(--button-color);
        width: 50%;
        height:50px;
        border-radius: 15%;
        font-size: 25px;
        color: aliceblue;
    }
    button:hover{
        cursor: pointer;
    }
  `
})
export class TableListComponent implements OnInit {

    tables: number[] = [];
    tableService: TableService = inject(TableService);

    myTable: string = "Table number";

    constructor(private window:MatDialogRef<TableListComponent>){}
    
    ngOnInit(): void {
        this.getAvailableTables();
    }

    getAvailableTables(): void{
        this.tableService.getAvailableTables().subscribe(data => this.tables = data);
    }

    closeTableList(num: number): void{
        if (num == 0)
            this.window.close("Choose a Table:");
        else
            this.window.close("Table " + num);
    }
    
}
