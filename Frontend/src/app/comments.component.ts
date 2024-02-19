import { Component, Input} from '@angular/core';
import { Item } from './item/item';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CommonModule],
  template: `
     <textarea name="comments" id="comments" cols="30" rows="10" placeholder="Any extra requests here:"></textarea>
  `,
  styles: ` 
    #comments{
        background-color: var(--button-color);
        color: aliceblue;
        font-size: large;
        padding: 5px;
        width: 86.5%;
        height: 200px;
        border-color: var(--border-color);
        margin: 40px 4.5% 40px 6% ;
    }
  `
})
export class CommentsComponent {

  @Input() item !: Item;

  
}
