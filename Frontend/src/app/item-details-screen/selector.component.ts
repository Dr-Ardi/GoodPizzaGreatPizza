import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Item } from '../variables/item/item';
import { Addables } from '../variables/addables/addables';
import { MatDialog } from '@angular/material/dialog';
import { TextComService } from '../tools/communicators/text-com.service';
import { ChoicesComponent } from '../tools/choices.component';
import { SizeSelectComponent } from '../tools/sizeSelect.component';
import { NumComService } from '../tools/communicators/num-com.service';
import { Size } from '../variables/size/size';
import { Added } from '../variables/added/added';
import { IncExComService } from '../tools/communicators/inc-ex-com.service';


@Component({
  selector: 'app-selector',
  standalone: true,
  imports: [CommonModule ],
  template: `
    <div id="selectors">

        <button *ngIf="this.added.sizable" class="selector" (click)="select()">Choose Size:</button>

        <button *ngIf="this.added.meats" class="selector" (click)="choose('meat')">Add Meat:</button>

        <button *ngIf="this.added.cheeses" class="selector" (click)="choose('cheese')">Add Cheese:</button>

        <button *ngIf="this.added.sauces" class="selector" (click)="choose('sauce')">Add Sauce:</button>

        <button *ngIf="this.added.extras" class="selector" (click)="choose('extra')">Add Extra:</button>

        <button *ngIf="this.added.removables" class="selector" (click)="choose('removable')">Remove Ingredient:</button>

        <div id="add">
            <button class="adders" (click)="addOrSubtract('minus')">-</button>
            <p id="quantity">{{this.quantity}}</p>
            <button class="adders" (click)="addOrSubtract('plus')">+</button>
        </div>

    </div>
  `,
  styles: `
    *{
      color: aliceblue;
    }
    #selectors{
        display: flex;
        justify-content: space-evenly;
        flex-wrap: wrap;
        column-gap: 100px;
    }
    
    .selector{
        width: 135px;
        padding: 5px;
        height: 40px;
        background-color: var(--button-color);
        border-color: var(--border-color);
        border-radius: 5%;
        margin: 10px;
    }

    #add{
        display: flex;
        height: 40px;
        width: 135px;
        background-color: transparent;
        align-items: center;
        justify-content: center;
        gap: 20px;
        margin: 10px;
    }
    #quantity{
        font-size: 20px;
    }

    .adders{
        background-color: var(--button-color);
        border-radius: 50%;
        border: solid 1px var(--border-color);
        height: 30px;
        width: 30px;
        font-size: 20px;
    }


    button:hover{
        cursor: pointer;
    }
  `
})
export class SelectorComponent implements OnInit {
  
  @Input() item !: Item;

  @Input() added !: Addables;

  @Input() finalPrice !: number;

  @Output() sendPrice: EventEmitter<any> = new EventEmitter<any>();

  quantity: number = 1;

  excluding: string = "";

  including: string = "";

  size: Size = {"id": 0, "item_Size": "none", "item_Type": "none", "added_Cost": 0};

  constructor(private choiceList:MatDialog,
              private selectCom: TextComService, 
              private numCom: NumComService,
              private incEx: IncExComService){}

  ngOnInit(): void {
  }

  addOrSubtract(msg: string): void{

    const pricePerItem = this.finalPrice / this.quantity;

    if (msg === 'plus' && this.quantity < 9) 
      this.quantity++;
    else if (msg === 'minus' && this.quantity > 1) 
      this.quantity--;

    var quantity = this.quantity.toString();
    this.numCom.sendQuantity(quantity);

    this.finalPrice = Number((pricePerItem * this.quantity).toFixed(2));

    this.sendPrice.emit(this.finalPrice);

  }

  select(): void{
    
    var temp = this.size.added_Cost;
    this.selectCom.sendMessage(this.item.type);
    var chosenSize = this.choiceList.open(SizeSelectComponent);

    chosenSize.afterClosed().subscribe((data:Size) => {
      
      this.size = data;
      this.finalPrice += (this.size.added_Cost - temp);

    })


    this.addOrSubtract('same');
  }

  choose(msg: string): void{
    
    const id = this.item.id.toString();
    this.selectCom.sendMessage(msg);
    this.numCom.sendId(id);

    var additions = this.choiceList.open(ChoicesComponent);

    additions.afterClosed().subscribe((data:any) =>{
      
      var added: string;
      var ingred: Added;

      if (msg == 'removable'){
        added = data;
        this.excluding += (added +", ");
      }
      else{
        data.forEach( (extra:Added) => {
          ingred = extra;
          this.including += ingred.added_Item ;

          if (ingred.add_Type == 'cheese')
            this.including += " cheese";

          this.including += ", ";

          this.finalPrice += ingred.added_Price;
        })
      }
    })

    this.addOrSubtract("same");
    this.incEx.setInclude(this.including);
    this.incEx.setExclude(this.excluding);
  }
}