import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Orders } from './orders';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  url = 'http://localhost:8080/gpgp/orders';

  constructor(private http: HttpClient) { }

  addToOrder(order: Orders): string{
    this.http.post<Orders>(this.url, order).subscribe((response) =>{
      return response;
    });
    return "Successfully added?";
  }

  getOrdersByTable(table: number): Observable<Orders[]>{
    return this.http.get<Orders[]>(`${this.url}/${table}`);
  }

  completeOrder(table:number): string{
    this.http.put(`${this.url}/${table}`, table).subscribe((response) => {
      return response;
    });
    return "Complete";
  }

  getFinalPrice(table: number): Observable<number>{
    return this.http.get<number>(`${this.url}/final/${table}`);
  }
}
