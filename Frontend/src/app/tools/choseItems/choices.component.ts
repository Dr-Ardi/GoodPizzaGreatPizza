import { Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { TextComService } from '../communicators/text-com.service';
import { FormsModule } from '@angular/forms';
import { GlobalVariablesService } from '../global-variables.service';

@Component({
  selector: 'app-choices',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './choices.component.html',
  styleUrl:'./choices.component.css'
})
export class ChoicesComponent implements OnInit {
    
    items!: any[] ;
    msg: string = "Add Ingredients";

    constructor(private window:MatDialogRef<ChoicesComponent>, private selectCom: TextComService, 
                private global: GlobalVariablesService){}
    
    ngOnInit(): void {
        this.selectCom.msg.subscribe((data) => {
            switch (data){
                case 'removeItems':
                    this.msg = "Remove Ingredients";
                    this.items = this.global.globalRemoves;
                    break;
                case 'meat':
                    this.items = this.global.globalMeats;
                    break;
                case 'cheese':
                    this.items = this.global.globalCheese;
                    break;
                case 'sauce':
                    this.items = this.global.globalSauce;
                    break;
                case 'extra':
                    this.items = this.global.globalExtra;
                    break;
            }
        });
    }

    showItem(item: any): string{
        if(this.msg == "Remove Ingredients")
            return item.ingredient_Name;
        else
            return (item.added_Item + ": + " + item.added_Price + "€");
    } 

    select(choice: any): void{
        choice.isItChecked = !choice.isItChecked; 
    }

    closeSelector(): void{
        this.sendSelectedItems
        this.window.close();
    }

    sendSelectedItems(): void{

        if(this.msg == "Remove Ingredients")
            this.global.globalRemoves = this.items;
        else{

            switch (this.items[0].add_Type){
                case 'meat':
                    this.global.globalMeats = this.items;
                    break;
                case 'cheese':
                    this.global.globalCheese = this.items;
                    break;
                case 'sauce':
                    this.global.globalSauce = this.items;
                    break;
                case 'extra':
                    this.global.globalExtra = this.items;
                    break;
            }

        }
    }

}

