import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TextComService {
  
  private selector = new BehaviorSubject<string>('');
  private comments = new BehaviorSubject<string>('');
  private size = new BehaviorSubject<string>('');

  msg = this.selector.asObservable();
  getComments = this.comments.asObservable();
  getSize = this.size.asObservable();

  sendMessage(msg: string){
    this.selector.next(msg);
  }

  sendComments(com: string){
    this.comments.next(com);
  }

  sendSize(size: string){
    this.size.next(size);
  }
}
