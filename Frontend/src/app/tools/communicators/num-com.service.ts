import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumComService {

  private quantity = new BehaviorSubject<string>('');
  private price = new BehaviorSubject<string>('');

  getQuantity = this.quantity.asObservable();
  getPrice = this.price.asObservable();

  sendQuantity(num: string){
    this.quantity.next(num);
  }
  
  sendPrice(num: string){
    this.price.next(num);
  }

}
