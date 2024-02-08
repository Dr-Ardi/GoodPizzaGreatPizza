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

  // async getAllItems(): Promise<Item[]> {
  //   const data = await fetch(this.url);
  //   return await data.json() ?? [];
  // }

  getAllItems(): Observable<Item[]>{
    return this.http.get<Item[]>(this.url);
  }
  

  // async getItemById(id: bigint): Promise<Item | undefined> {
  //   const data = await fetch(`${this.url}/${id}`);
  //   return await data.json() ?? {};
  // }

  
}
