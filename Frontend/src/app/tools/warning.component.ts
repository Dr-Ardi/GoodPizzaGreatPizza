import { Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-warning',
  standalone: true,
  imports: [CommonModule],
  template: `

    <div id="all">
        <div class="card">
            <h2>Are you sure you want to leave this table?</h2>
            <button (click)="closeWarning('Yes')">Yes</button>
            <button id="deny" (click)="closeWarning('No')">No</button>
        </div>
    </div>
     
  `,
  styles: ` 
    ::-webkit-scrollbar {
        display: none;
    }
    #all{
        position: fixed;
        background-color: transparent;
        backdrop-filter: brightness(70%);
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        top: 0px;
        animation: fadeIn 0.3s ease-in-out forwards;
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    .card{
        width: 300px;
        height: 150px;
        background-color: var(--button-color);
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
    }
    .card > button {
        width:100px;
        height: 40px;
        font-size: 20px;
    }
    button:hover{
        cursor:pointer;
    }

    #deny{
        background-color: var(--primary-color);
    }
  `
})
export class WarningComponent {

    constructor(private window:MatDialogRef<WarningComponent>){}
    
    closeWarning(msg: string): void {
        this.window.close(msg);
    }

}