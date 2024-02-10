import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home-screen',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl:'./home-screen.component.html',
  styleUrl: './home-screen.component.css'
})
export class HomeScreenComponent {}
