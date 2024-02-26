import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Orders } from './orders';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  url = 'http://localhost:8080/gpgp/orders';

  constructor(private http: HttpClient) { }

  addToOrder(order: Orders): string{
    this.http.post<Orders>(this.url, order).pipe(
      catchError((error) => {
        console.log("There was an error", error);
        throw error;
      }));
    return "Successfully added";
  }
}
