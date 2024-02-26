import { Component, Input} from '@angular/core';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { BackButtonDirective } from './back-button.directive';

@Component({
  selector: 'app-back',
  standalone: true,
  imports: [CommonModule, BackButtonDirective],
  template: `
     <div class="goBack">
        <button id="back" appBackButton>Back</button>
    </div>
  `,
  styles: ` 
    .goBack{
        display: flex;
        height: 40px;
        width: 100%;
        justify-content: flex-end;
        align-items:center;
        position: sticky;
        top:inherit;
        background-color: var(--background-color);
        border-bottom: solid 1px #555;
    }
    #back{
        width: 100px;
        height: 40px;
        font-size: calc(var(--headline)/var(--golden-ratio));
        background-color: transparent;
        color: var(--primary-color);
        border: 0px;
    }
    #back:hover{
        color: var(--hover-color);
        cursor: pointer;
    }
  `
})
export class BackComponent {

  @Input() item !: Item;

  
}