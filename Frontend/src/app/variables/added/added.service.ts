import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Added }  from './added';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddedService {

  url = 'http://localhost:8080/gpgp/added';

  constructor(private http: HttpClient) { }

  getItemsByType(type: String): Observable<Added[]>{
    return this.http.get<Added[]>(`${this.url}/${type}`).pipe(
      map((added: Added[]) => {
        return added.map((item: Added) => ({
          id: item.id,
          add_Type: item.add_Type,
          added_Item: item.added_Item,
          added_Price: item.added_Price,
          isItChecked: false,
        }))
      })
    );
  }
}
