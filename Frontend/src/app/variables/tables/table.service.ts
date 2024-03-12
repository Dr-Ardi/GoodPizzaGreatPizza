import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TableService {

  url = "http://localhost:8080/gpgp/restaurant_Tables";
  constructor(private http: HttpClient) { }

  getAvailableTables(): Observable<number[]>{
    return this.http.get<number[]>(`${this.url}/free`);
  }

  callWaiter(table: number): any{

    this.http.put(`${this.url}/waiter/${table}`, table).subscribe((response) => {
      return response;
    });
    return "Waiter Called";
  }

  finished(table: number): any{

    this.http.put(`${this.url}/${table}`, table).subscribe((response) => {
      return response;
    });
    return "Restaurant Notified";
  }

  selectPaymentMethod(table: number, payment: string): any{
    this.http.put(`${this.url}/payment/${table}?payment=${payment}`, payment).subscribe((response)=>{
      return response;
    });
    return "Updated";
  }
}
