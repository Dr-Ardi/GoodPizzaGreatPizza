import { Component, Input, OnInit, inject } from '@angular/core';
import { Item } from './item/item';
import { CommonModule } from '@angular/common';
import { IngredientService } from './ingredient.service';

@Component({
  selector: 'app-desc',
  standalone: true,
  imports: [CommonModule],
  template: `
    {{this.description}}
  `,
  styles: ` `
})
export class DescComponent implements OnInit {

  @Input() item !: Item;
  ingredientService: IngredientService = inject(IngredientService);

  description: string = "type ";

  ngOnInit(): void {

    if (this.item.type == "Soft Drink" || this.item.type == "Wine")
      this.description = this.description.replace("type", this.item.name.toLowerCase());
    else if ( this.item.type == "Appetiser" || this.item.name == "French Fries")
      this.description = this.description.replace("type", ("portion of " + this.item.name.toLowerCase()));
    else
      this.description = this.description.replace("type", this.item.type.toLowerCase());

    this.setDescription(this.item.id);
  }

  setDescription(id: number): void{

    this.ingredientService.getIngredients(id).subscribe(data => this.description += data);

    if (this.description.charAt(0) == 'a' || this.description.charAt(0) == 'e' || 
      this.description.charAt(0) == 'i' || this.description.charAt(0) == 'o' || 
      this.description.charAt(0) == 'u')
        this.description = "An " + this.description;
    else
      this.description = "A " + this.description;

  }

  
}
