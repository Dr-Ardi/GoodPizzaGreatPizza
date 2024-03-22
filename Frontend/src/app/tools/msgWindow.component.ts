import { Component, Inject} from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-msg-window',
  standalone: true,
  imports: [],
  template: `
    <div>
        <p>{{data}}</p>
    </div>
  `,
  styles: ` 
    div{
        position: fixed;
        background-color: transparent;
        backdrop-filter: brightness(80%);
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        top: 0px;
    }
    p{
        font-size: 35px;
        padding: 25px 50px 25px 50px;
        background-color: rgba(51, 51, 51, 0.85);
        color: aliceblue;
        border-radius: 10px;
    }
  `
})
export class MsgWindowComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
            private window:MatDialogRef<MsgWindowComponent>){

    setTimeout(() => {
        this.window.close();
    }, 1000);
  }
}