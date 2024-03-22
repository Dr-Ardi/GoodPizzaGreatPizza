import { Component,  OnChanges,  OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogRef } from '@angular/material/dialog';
import { SizeService } from '../../variables/size/size.service';
import { FormsModule } from '@angular/forms';
import { Size } from '../../variables/size/size';
import { TextComService } from '../communicators/text-com.service';

@Component({
  selector: 'app-sizeSelect',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sizeSelect.component.html',
  styleUrl:'./sizeSelect.component.css' 
})
export class SizeSelectComponent implements OnInit, OnChanges {

    choices!: Size[] ;
    chosen!: Size;
    type!: string;

    default: any = localStorage.getItem("defaultSize");

    constructor(private window:MatDialogRef<SizeSelectComponent>, private typeCom: TextComService,
                private sizeService: SizeService){}
    
    ngOnInit(): void {
        this.typeCom.msg.subscribe((msg) => this.type = msg);
        this.getSizesByType(this.type);
    }
    
    ngOnChanges(): void {}

    closeSelector(): void{
        this.window.close(0);
    }

    chosenItem(): void{
        this.window.close(this.chosen);
    }

    isItSelected(choice: any) :boolean{
        if(choice.id.toString() == this.default)
            return true;

        return false;
    }
    getSizesByType(type: string): void{
        this.sizeService.getSizesByType(type).subscribe(sizes => this.choices = sizes);
    }

    showChoices(choice: Size): string{
        var tag: string = "";
        if (choice.added_Cost != 0)
            tag = choice.item_Size + ": +" + choice.added_Cost + "$";
        else
            tag = choice.item_Size;
        return tag;
    }

    selectSize(choice: Size): void{
        this.chosen = choice;
        this.typeCom.sendSize(choice.item_Size);
        localStorage.setItem("defaultSize", choice.id.toString());
    }
}

