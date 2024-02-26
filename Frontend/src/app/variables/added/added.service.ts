import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Added }  from './added';

@Injectable({
  providedIn: 'root'
})
export class AddedService {

  url = 'http://localhost:8080/gpgp/added';

  constructor(private http: HttpClient) { }

  getItemsByType(type: String): Observable<Added[]>{
    return this.http.get<Added[]>(`${this.url}/${type}`);
  }
}
