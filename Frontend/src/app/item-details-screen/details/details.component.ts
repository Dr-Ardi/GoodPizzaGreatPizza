import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'
import { CommentsComponent } from '../../tools/comments.component';
import { Addables } from '../../variables/addables/addables';
import { AddablesService } from '../../variables/addables/addables.service';
import { SelectorComponent } from '../selector/selector.component';
import { NumComService } from '../../tools/communicators/num-com.service';


@Component({
  selector: 'app-details',
  standalone: true,
  imports: [CommonModule, FormsModule, CommentsComponent, SelectorComponent],
  templateUrl: './details.component.html' ,
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit {

  @Input() item !: Item;

  finalPrice : number = 0;
  initial : number = 0;
  
  added!: Addables;

  constructor(private priceCom: NumComService, private addablesService: AddablesService){
  }

  ngOnInit(): void {
      this.initial = this.item.price;
      this.finalPrice = this.item.price;
      this.inputPrice(this.finalPrice);
      this.getAddablesByType(this.item.type);
  }

  getAddablesByType(type: string): void{
    this.addablesService.getAddablesByType(type).subscribe((addables:Addables) => this.added = addables);
  }

  inputPrice(finalPrice: number): void{
    this.finalPrice = finalPrice;
    var finPrice = this.finalPrice.toString();
    this.priceCom.sendPrice(finPrice);
  }
  
}
