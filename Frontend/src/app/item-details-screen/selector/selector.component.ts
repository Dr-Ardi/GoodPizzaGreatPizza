import { Component, EventEmitter, Input, OnChanges, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Item } from '../../variables/item/item';
import { Ingredient } from '../../variables/ingredients/ingredient';
import { Addables } from '../../variables/addables/addables';
import { Added } from '../../variables/added/added';
import { Size } from '../../variables/size/size';
import { IngredientService } from '../../variables/ingredients/ingredient.service';
import { AddedService } from '../../variables/added/added.service';
import { GlobalVariablesService } from '../../tools/global-variables.service';
import { MatDialog } from '@angular/material/dialog';
import { SizeSelectComponent } from '../../tools/sizeSelect/sizeSelect.component';
import { ChoicesComponent } from '../../tools/choseItems/choices.component';
import { TextComService } from '../../tools/communicators/text-com.service';
import { NumComService } from '../../tools/communicators/num-com.service';


@Component({
  selector: 'app-selector',
  standalone: true,
  imports: [CommonModule ],
  templateUrl: './selector.component.html',
  styleUrl: './selector.component.css'
})
export class SelectorComponent implements OnChanges {
  
  @Input() item !: Item;

  @Input() added !: Addables;

  @Input() currentPrice !: number;

  @Output() sendPrice: EventEmitter<any> = new EventEmitter<any>();
  
  extraPriceSize: number = 0;
  finalPrice: number = this.currentPrice;
  quantity: number = 1;
  size: Size = {"id": 0, "item_Size": "none", "item_Type": "none", "added_Cost": 0};

  constructor(private choiceList:MatDialog, private selectCom: TextComService, 
              private numCom: NumComService, private global: GlobalVariablesService,
              private addedService: AddedService, private ingredService: IngredientService){}

  ngOnChanges(): void {
    this.setItems(this.added);
  }

  setItems(added: Addables): void{

    if(added.meats)
      this.addedService.getItemsByType("meat").subscribe((meat: Added[]) =>this.global.globalMeats = meat);

    if(added.cheeses)
      this.addedService.getItemsByType("cheese").subscribe((cheese: Added[]) =>this.global.globalCheese = cheese);

    if(added.sauces)
      this.addedService.getItemsByType("sauce").subscribe((sauce: Added[]) =>this.global.globalSauce = sauce);
    
    if(added.extras)
      this.addedService.getItemsByType("extra").subscribe((extra: Added[]) =>this.global.globalExtra = extra);

    if(added.removables)
      this.ingredService.findIngredientsById(this.item.id).subscribe((ingreds: Ingredient[]) => this.global.globalRemoves = ingreds)
  }

  select(): void{
    
    var temp = this.size.item_Size;
    this.selectCom.sendMessage(this.item.type);
    var chosenSize = this.choiceList.open(SizeSelectComponent);

    chosenSize.afterClosed().subscribe((data:any) => {

      if(data != 0){

        if(temp != data.item_Size){
          this.size = data;
          this.extraPriceSize = data.added_Cost;
          this.addOrSubtract('same');
        }
      }

    })

  }


  choose(msg: string): void{
    this.selectCom.sendMessage(msg);

    var additions = this.choiceList.open(ChoicesComponent);

    additions.afterClosed().subscribe((data:any) =>{
      this.addOrSubtract("same");
    })
  }


  addOrSubtract(msg: string): void{

    const pricePerItem = (this.currentPrice + this.extraPriceSize + this.global.calculateExtraPrice()) ;

    if (msg === 'plus' && this.quantity < 9) 
      this.quantity++;
    else if (msg === 'minus' && this.quantity > 1) 
      this.quantity--;

    var quantity = this.quantity.toString();
    this.numCom.sendQuantity(quantity);

    this.finalPrice = Number((pricePerItem * this.quantity).toFixed(2));

    this.sendPrice.emit(this.finalPrice);

  }
  
}