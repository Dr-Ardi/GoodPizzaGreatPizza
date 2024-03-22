import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Ingredient } from './ingredient';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  url = 'http://localhost:8080/gpgp/ingredients';

  constructor(private http: HttpClient) { }

  getIngredients(id: number): Observable<string>{
    return this.http.get<string>(`${this.url}/desc/${id}`);
  }

  findIngredientsById(id: number): Observable<Ingredient[]>{
    return this.http.get<Ingredient[]>(`${this.url}/${id}`).pipe(
      map((ingredients: Ingredient[]) => {
        return ingredients.map((ingredient: Ingredient) => ({
          id: ingredient.id,
          item_Id: ingredient.item_Id,
          ingredient_Name: ingredient.ingredient_Name,
          isItChecked: false,
        }))
      })
    );
  }
}
