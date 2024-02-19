import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../item/item.service';
import { Item } from '../item/item';
import { CommonModule } from '@angular/common';
import { SelectorComponent } from '../selector/selector.component';
import { PhotoComponent } from '../photo/photo.component';
import { DescComponent } from '../desc.component';

@Component({
  selector: 'app-item-details',
  standalone: true,
  imports: [CommonModule, SelectorComponent, PhotoComponent, DescComponent],
  templateUrl: './item-details.component.html',
  styleUrl: './item-details.component.css'
})
export class ItemDetailsComponent implements OnInit {
  
  route: ActivatedRoute = inject(ActivatedRoute);
  item !: Item;

  constructor(private itemService: ItemService){
    const itemId = Number(this.route.snapshot.params['id']);
    this.getItemById(itemId);
  }

  ngOnInit(): void{ 
  }

  getItemById(itemId: number): void {
    this.itemService.getItemById(itemId).subscribe(item => this.item = item);
  }

}
