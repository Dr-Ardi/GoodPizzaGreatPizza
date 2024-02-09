import { Component, Input, OnInit } from '@angular/core';
import { Item } from '../item';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-menu-items',
  standalone: true,
  imports: [CommonModule],
  templateUrl:'./menu-items.component.html' ,
  styleUrl: './menu-items.component.css'
})
export class MenuItemsComponent {

  ImageUrl = 'https://users.iee.ihu.gr/~iee2021162/GPGP';
  photoSrc!: string;
  
  @Input() item!: Item;

  ngOnInit(): void{
    this.setPhotoSrc();
  }

  setPhotoSrc(): any{
    this.photoSrc = `${this.ImageUrl}/${this.item.type}`;

    if(this.item.name == "French Fries")
      this.photoSrc = `${this.ImageUrl}/Fries`;
    
    if(this.item.name == "Water")
      this.photoSrc = `${this.ImageUrl}/Water`;
  }
  
}
