import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  url = 'http://localhost:8080/gpgp/ingredients';

  constructor(private http: HttpClient) { }

  getIngredients(id: number): Observable<string>{
    return this.http.get<string>(`${this.url}/desc/${id}`);
  }

  findIngredientsById(id: number): Observable<string[]>{
    return this.http.get<string[]>(`${this.url}/${id}`);
  }
}
