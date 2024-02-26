import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TextComService {
  
  private selector = new BehaviorSubject<string>('');
  private comments = new BehaviorSubject<string>('');

  msg = this.selector.asObservable();
  getComments = this.comments.asObservable();

  sendMessage(msg: string){
    this.selector.next(msg);
  }

  sendComments(com: string){
    this.comments.next(com);
  }
}
