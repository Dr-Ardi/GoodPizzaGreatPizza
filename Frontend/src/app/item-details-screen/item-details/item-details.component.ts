import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ItemService } from '../../variables/item/item.service';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from '../details/details.component';
import { PhotoComponent } from '../../tools/photo/photo.component';
import { DescComponent } from '../../tools/desc.component';
import { BackComponent } from '../../tools/backButton/back.component';
import { IncExComService } from '../../tools/communicators/inc-ex-com.service';
import { TextComService } from '../../tools/communicators/text-com.service';
import { NumComService } from '../../tools/communicators/num-com.service';
import { Orders } from '../../variables/orders/orders';
import { OrderService } from '../../variables/orders/order.service';

@Component({
  selector: 'app-item-details',
  standalone: true,
  imports: [CommonModule, DetailsComponent, PhotoComponent, DescComponent, BackComponent, RouterModule],
  templateUrl: './item-details.component.html',
  styleUrl: './item-details.component.css'
})
export class ItemDetailsComponent implements OnInit {
  
  route: ActivatedRoute = inject(ActivatedRoute);
  item!: Item;

  table: any = localStorage.getItem("table");
  quantity!: number;
  includes!: string;
  excludes!: string;
  comments!: string;
  finalPrice!: number;
  size!: string;
  orderService: OrderService = inject(OrderService);
  
  constructor(private itemService: ItemService, private incEx: IncExComService,
              private extraCom: TextComService, private numsCom: NumComService){
    const itemId = Number(this.route.snapshot.params['id']);
    this.getItemById(itemId);
    this.getItems();
  }

  ngOnInit(): void{ 
  }

  getItems(): void{
    this.incEx.include.subscribe((include: string) => this.includes = include);
    this.incEx.exclude.subscribe((exclude: string) => this.excludes = exclude);
    this.extraCom.getComments.subscribe((comments: string) => this.comments = comments);
    this.numsCom.getQuantity.subscribe((quantity: string) => this.quantity = parseInt(quantity));
    this.numsCom.getPrice.subscribe((finalPrice: string) => this.finalPrice = parseFloat(finalPrice));
    this.extraCom.getSize.subscribe((size: string) => this.size = size);
  }

  getItemById(itemId: number): void {
    this.itemService.getItemById(itemId).subscribe((item:Item) => this.item = item);
  }

  addToOrder(): void{
    var order: Orders = {"table_Number": parseInt(this.table), "priority": this.item.priority, 
      "item_Name": this.item.name, "extra": this.comments, "included": this.includes, 
      "excluded": this.excludes, "quantity": this.quantity, "ordered": false, 
      "order_Cost": this.finalPrice, "size": this.size};
    
    var msg = this.orderService.addToOrder(order) ;
    console.log(msg);
  }

}
