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
}
