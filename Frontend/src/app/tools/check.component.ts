import { Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-check',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
     <input type="checkbox" [(ngModel)]="choice.checked">
  `,
  styles: ` 
  `
})
export class CheckComponent {

    @Input() name!: string;

    choice={label: this.name, checked: false}
  
}