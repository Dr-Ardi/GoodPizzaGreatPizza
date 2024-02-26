import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Size } from './size';

@Injectable({
  providedIn: 'root'
})
export class SizeService {

  url = 'http://localhost:8080/gpgp/sizes';

  constructor(private http: HttpClient) { }

  getSizesByType(type: string): Observable<Size[]>{
    return this.http.get<Size[]>(`${this.url}/${type}`);
  }
}
