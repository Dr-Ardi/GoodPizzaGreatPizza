import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../variables/item/item';
import { CommonModule } from '@angular/common';
import { IngredientService } from '../variables/ingredients/ingredient.service';

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
  description!: string;

  constructor(private ingredientService: IngredientService){}

  ngOnInit(): void {
    this.ingredientService.getIngredients(this.item.id).subscribe((data: string) => this.description = data);
  }
  
}
