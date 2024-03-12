import { Component,  OnInit, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { SizeService } from '../variables/size/size.service';
import { FormsModule } from '@angular/forms';
import { Size } from '../variables/size/size';
import { TextComService } from './communicators/text-com.service';

@Component({
  selector: 'app-sizeSelect',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div id="all">
        <div id="choiceList">
            <div id="titleCard">
                <p>Choose a Size: </p>
                <button id="close" (click)="closeSelector()">Done</button> 
            </div>

            <form class="list">
                <label class="choice" *ngFor="let choice of choices" (click)="selectSize(choice)"> {{this.showChoices(choice)}} 
                    <input type="radio" [id]="choice" name="size">
                </label>    
            </form>

        </div>
    <div>
  `,
  styles: ` 

    ::-webkit-scrollbar {
        width: 0px;
    }

    #all{
        position: fixed;
        background-color: transparent;
        backdrop-filter: brightness(50%);
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
    #choiceList{
        background-color: #333;
        width:300px;
        height: fit-content;
        max-height: 500px;
        display: flex;
        overflow-x: scroll;
        flex-direction: column;
        padding: 5px;
        border-radius: 15%;
    }

    #titleCard{
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin-bottom: 5px;
        border-bottom: solid 1px var(--border-color);
        padding: 5px;
    }
    #close{
        border:0px;
        background-color: transparent;
        color: var(--primary-color);
    }
    .list{
        margin-top: 5px;
        display:flex;
        flex-direction: column;
        gap: 10px;
        width:100%;
        align-items: center;
    }
    .choice{
        display: block;
        background-color: #222;
        width: 65%;
        padding: 20px 0px 20px 0px;
        margin: 10px 0px 10px 0px;
        text-align: center;
        border-radius: 10%;
    }
    button,.choice:hover{
        cursor: pointer;
    }
  `
})
export class SizeSelectComponent implements OnInit {

    choices!: Size[] ;

    chosen!: Size;

    type!: string;

    sizeService: SizeService = inject(SizeService);

    constructor(private window:MatDialogRef<SizeSelectComponent>, 
                private typeCom: TextComService){}
    
    ngOnInit(): void {
        this.typeCom.msg.subscribe((msg) => this.type = msg);
        this.getSizesByType(this.type);
    }

    closeSelector(): void{
        this.window.close(this.chosen);
    }

    getSizesByType(type: string): void{
        this.sizeService.getSizesByType(type).subscribe(sizes => this.choices = sizes);
    }

    showChoices(choice: Size): string{
        var tag: string = "";
        if (choice.added_Cost != 0)
            tag = choice.item_Size + ": +" + choice.added_Cost + "$";
        else
            tag = choice.item_Size;
        return tag;
    }

    selectSize(choice: Size): void{
        this.chosen = choice;
        this.typeCom.sendSize(choice.item_Size);
    }
}

