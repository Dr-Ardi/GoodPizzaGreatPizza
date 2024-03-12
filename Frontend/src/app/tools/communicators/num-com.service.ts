import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumComService {

  private id = new BehaviorSubject<string>('');
  private quantity = new BehaviorSubject<string>('');
  private price = new BehaviorSubject<string>('');

  getId = this.id.asObservable();
  getQuantity = this.quantity.asObservable();
  getPrice = this.price.asObservable();


  sendId(num: string){
    this.id.next(num);
  }

  sendQuantity(num: string){
    this.quantity.next(num);
  }

  sendPrice(num: string){
    this.price.next(num);
  }

}
