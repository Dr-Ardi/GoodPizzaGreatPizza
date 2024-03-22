import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Table } from '../variables/tables/table';
import { TableService } from '../variables/tables/table.service';
import { TablesComponent } from './tables/tables/tables.component';

@Component({
  selector: 'app-restaurant',
  standalone: true,
  imports: [CommonModule, TablesComponent],
  templateUrl:'./restaurant.component.html' ,
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent implements OnInit {

  tables: Table[] = [];

  constructor(private tableService: TableService){}

  ngOnInit(): void {
    this.tableService.getAllTables().subscribe((tables: Table[]) => {
      this.tables = tables;
    });
  }
}
