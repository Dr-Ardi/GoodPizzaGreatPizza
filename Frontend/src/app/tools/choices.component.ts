import { Component,  OnInit, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { TextComService } from './communicators/text-com.service';
import { IngredientService } from '../variables/ingredient.service';
import { AddedService } from '../variables/added/added.service';
import { NumComService } from './communicators/num-com.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-choices',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div id="all">
        <div id="choiceList">
            <div id="titleCard">
                <p>{{this.msg}}</p>
                <button id="close" (click)="closeSelector()">Done</button> 
            </div>
            <div class="list">
                <label class="choice" *ngFor="let choice of choices" > 
                <span class="choiceTag">{{this.showChoices(choice)}}</span>
                    <input type="checkbox" (change)="addItem(choice)">
                </label>
            </div>
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
export class ChoicesComponent implements OnInit {

    choices!: any[] ;

    added: any[] =[];

    itemId!: number;
    msg!: string;

    ingredientService: IngredientService = inject(IngredientService);
    addedService: AddedService = inject(AddedService);

    constructor(private window:MatDialogRef<ChoicesComponent>, 
                private selectCom: TextComService, 
                private idCom: NumComService){}
    
    ngOnInit(): void {
        this.idCom.getId.subscribe((id: string) => this.itemId = parseInt(id));
        this.selectCom.msg.subscribe((data) => {
            switch (data){
                case 'removable':
                    this.msg = "Remove Ingredients";
                    this.getIngredientById(this.itemId);
                    break;
                default:
                    this.msg = "Add Ingredients";
                    this.getItemByType(data);
                    break;
            }
          });
    }

    closeSelector(): void{
        this.window.close(this.added);
    }

    getIngredientById(id: number): void{
        this.ingredientService.findIngredientsById(id).subscribe(ingred => this.choices = ingred);
    }

    getItemByType(type: string): void{
        this.addedService.getItemsByType(type).subscribe(added => this.choices = added);
    }

    showChoices(choice: any): string{
        var tag: string = "";
        if (this.msg == "Remove Ingredients")
            return choice;
        else 
            tag = choice.added_Item + ": +" + choice.added_Price + "$";

        return tag;
    }

    addItem(choice: any): void{
        if (this.added.includes(choice))
            this.added = this.added.filter(content => content !== choice);  
        else
            this.added.push(choice);
    }
}

