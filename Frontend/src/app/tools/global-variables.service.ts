import { Injectable } from '@angular/core';
import { Added } from '../variables/added/added';
import { Ingredient } from '../variables/ingredients/ingredient';

@Injectable({
  providedIn: 'root'
})
export class GlobalVariablesService {

  globalMeats!: Added[];
  globalCheese!: Added[];
  globalSauce!: Added[];
  globalExtra!: Added[];
  globalRemoves!: Ingredient[];

  constructor() { }

  calculateExtraPrice(): number{

    var extraPrice = 0;

    if (this.globalMeats){
      this.globalMeats.forEach((meat) => {
        if (meat.isItChecked)
          extraPrice += meat.added_Price;
      });
    }

    if(this.globalCheese){
      this.globalCheese.forEach((cheese) => {
        if (cheese.isItChecked)
          extraPrice += cheese.added_Price;
      });
    }

    if(this.globalSauce){
      this.globalSauce.forEach((sauce) => {
        if (sauce.isItChecked)
          extraPrice += sauce.added_Price;
      });
    }

    if(this.globalExtra){
      this.globalExtra.forEach((extra) => {
        if (extra.isItChecked)
          extraPrice += extra.added_Price;
      });
    }

    return extraPrice;
  }

  getIncludes(): string{

    var includes = "";

    if (this.globalMeats){
      this.globalMeats.forEach((meat) => {
        if (meat.isItChecked){
          includes += meat.added_Item;
          includes += ", ";
        }
      });
    }

    if(this.globalCheese){
      this.globalCheese.forEach((cheese) => {
        if (cheese.isItChecked){
          includes += cheese.added_Price;
          includes += ", ";
        }
      });
    }

    if(this.globalSauce){
      this.globalSauce.forEach((sauce) => {
        if (sauce.isItChecked){
          includes += sauce.added_Item;
          includes += ", ";
        }
      });
    }

    if(this.globalExtra){
      this.globalExtra.forEach((extra) => {
        if (extra.isItChecked){
          includes += extra.added_Item;
          includes += ", ";
        }
      });
    }

    return includes;
  }

  getExcludes(): string{
    var excludes = "";

    if(this.globalRemoves){
      this.globalRemoves.forEach((remove) => {
        if (remove.isItChecked){
          excludes += remove.ingredient_Name;
          excludes += ", ";
        }
      });
    }

    return excludes;
  }
}
