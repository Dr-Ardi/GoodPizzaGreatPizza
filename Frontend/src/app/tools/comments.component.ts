import { Component, Input} from '@angular/core';
import { Item } from '../variables/item/item';
import { CommonModule } from '@angular/common';
import { TextComService } from './communicators/text-com.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
     <textarea name="comments" id="comments" cols="30" rows="10"
      (change)="commitComments()" [(ngModel)]="comments" placeholder="Any extra requests here:">
    </textarea>
  `,
  styles: ` 
    #comments{
        background-color: var(--button-color);
        font-size: large;
        padding: 5px;
        width: 80.5%;
        height: 200px;
        border-color: var(--border-color);
        margin: 40px 7.5% 40px 9% ;
        color: aliceblue;
    }
  `
})
export class CommentsComponent {

  @Input() item !: Item;

  comments:string ='';

  constructor(private extraCom: TextComService){}

  commitComments(): void{
    this.extraCom.sendComments(this.comments);
  }
  
}
