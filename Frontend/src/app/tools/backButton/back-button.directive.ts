import { Directive, HostListener } from '@angular/core';
import { Location } from '@angular/common';

@Directive({
  selector: '[appBackButton]',
  standalone: true
})
export class BackButtonDirective {
  constructor(private location: Location) { }

  @HostListener('click')
  onClick() {
      this.location.back();
  }
}