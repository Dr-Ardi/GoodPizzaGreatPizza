import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncExComService {
  
  private inc = new BehaviorSubject<string>('');
  private ex = new BehaviorSubject<string>('');

  include = this.inc.asObservable();
  exclude = this.ex.asObservable();

  setInclude(include: string){
    this.inc.next(include);
  }

  setExclude(exclude: string){
    this.ex.next(exclude);
  }
}
