import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-menu-bar',
  standalone: true,
  imports: [],
  template: `
        <button class="tagButton" (click)="scrollToSection(type)">{{type}}</button>
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
