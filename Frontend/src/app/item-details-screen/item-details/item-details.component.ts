import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ItemService } from '../../variables/item/item.service';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from '../details/details.component';
import { PhotoComponent } from '../../tools/photo/photo.component';
import { DescComponent } from '../../tools/desc.component';
import { TextComService } from '../../tools/communicators/text-com.service';
import { NumComService } from '../../tools/communicators/num-com.service';
import { Orders } from '../../variables/orders/orders';
import { OrderService } from '../../variables/orders/order.service';
import { GlobalVariablesService } from '../../tools/global-variables.service';

@Component({
  selector: 'app-item-details',
  standalone: true,
  imports: [CommonModule, DetailsComponent, PhotoComponent, DescComponent, RouterModule],
  templateUrl: './item-details.component.html',
  styleUrl: './item-details.component.css'
})
export class ItemDetailsComponent implements OnInit {
  
  item!: Item;

  table: any = localStorage.getItem("table");
  quantity!: number;
  comments!: string;
  finalPrice!: number;
  size!: string;
  
  constructor(private itemService: ItemService, private extraCom: TextComService, 
              private numsCom: NumComService, private global: GlobalVariablesService,
              private orderService: OrderService, private route: ActivatedRoute){
    const itemId = Number(this.route.snapshot.params['id']);
    this.getItemById(itemId);
    this.getItems();
  }

  ngOnInit(): void{ 
  }
  
  getItemById(itemId: number): void {
    this.itemService.getItemById(itemId).subscribe((item:Item) => this.item = item);
  }

  getItems(): void{
    this.extraCom.getComments.subscribe((comments: string) => this.comments = comments);
    this.numsCom.getQuantity.subscribe((quantity: string) => this.quantity = parseInt(quantity));
    this.numsCom.getPrice.subscribe((finalPrice: string) => this.finalPrice = parseFloat(finalPrice));
    this.extraCom.getSize.subscribe((size: string) => this.size = size);
  }
  
  addToOrder(): void{
    var order: Orders = {"table_Number": parseInt(this.table), "priority": this.item.priority, 
      "item_Name": this.item.name, "extra": this.comments, "included": this.global.getIncludes(), 
      "excluded": this.global.getExcludes(), "quantity": this.quantity, "ordered": false, 
      "order_Cost": this.finalPrice, "size": this.size};
    
    var msg = this.orderService.addToOrder(order) ;
    localStorage.setItem("defaultSize", "");
    window.location.reload();
  }

}
