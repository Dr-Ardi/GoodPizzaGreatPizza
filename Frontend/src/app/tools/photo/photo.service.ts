import { Injectable } from '@angular/core';
import { Item } from '../../variables/item/item';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  ImageUrl = 'https://users.iee.ihu.gr/~iee2021162/GPGP';
  photoSrc!: string;

  getPhotoSrc(item: Item): string{
    this.photoSrc = `${this.ImageUrl}/${item.type}`;

    if(item.name == "French Fries")
      this.photoSrc = `${this.ImageUrl}/Fries`;
    
    if(item.name == "Water")
      this.photoSrc = `${this.ImageUrl}/Water`;

    return this.photoSrc;
  }

}
