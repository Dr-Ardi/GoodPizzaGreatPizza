import { CommonModule } from '@angular/common';
import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-menu-bar',
  standalone: true,
  imports: [CommonModule],
  template: `
      <section *ngIf="type !== 'Water' && type !=='Fries'">
          <button class="tagButton" (click)="scrollToSection(type)">{{type}}</button>
      </section>
  `,
  styleUrl: './menu-bar.component.css'
})
export class MenuBarComponent {
  @Input() type!: string;

  scrollToSection(tagId: string) {
    const tag = document.getElementById(tagId);
    if (tag) {
      tag.scrollIntoView({ behavior: 'smooth' });
    }
  }
}
