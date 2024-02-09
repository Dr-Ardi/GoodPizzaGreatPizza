import { Injectable } from '@angular/core';
import { Item } from './item';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient){}

   url = 'http://localhost:8080/gpgp/items';

  getAllItems(): Observable<Item[]>{
    return this.http.get<Item[]>(this.url);
  }
  
  getEachType(): Observable<string[]>{
    return this.http.get<string[]>(`${this.url}/types`);
  }
  
}
