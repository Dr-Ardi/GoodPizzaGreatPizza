import { Component, Input, OnInit, inject } from '@angular/core';
import { Item } from '../../variables/item/item';
import { CommonModule } from '@angular/common';
import { PhotoService } from './photo.service';

@Component({
  selector: 'app-photo',
  standalone: true,
  imports: [CommonModule],
  template: `
    <img [src]="this.photoSrc" alt="{{item.name}}">
  `,
  styles: `
    img{
        width: 100%;
        height: 100%;
        border-radius: inherit;
        margin-top: inherit;
        margin-bottom: inherit;
        max-height: inherit;
    }
  `
})
export class PhotoComponent implements OnInit {

  @Input() item !: Item;

  photoSrc!: string;

  constructor(private photoService: PhotoService){}

  ngOnInit(): void {
      this.getPhotoSrc(this.item);
  }

  getPhotoSrc(item: Item): void{
    this.photoSrc = this.photoService.getPhotoSrc(item);
  }
  
}
