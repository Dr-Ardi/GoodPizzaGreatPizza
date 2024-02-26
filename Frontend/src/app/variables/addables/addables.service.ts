import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addables } from './addables';

@Injectable({
  providedIn: 'root'
})
export class AddablesService {

  url = 'http://localhost:8080/gpgp/addables';

  constructor(private http: HttpClient) { }

  getAddablesByType(type: String): Observable<Addables>{
    return this.http.get<Addables>(`${this.url}/${type}`);
  }
}
