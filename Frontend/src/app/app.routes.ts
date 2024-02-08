import { Routes } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { MenuComponent } from './menu/menu.component';

export const routes: Routes = [
    {
        path:'',
        component: HomeScreenComponent,
        title:'Home Screen',
    },
    {
        path:'menu',
        component: MenuComponent,
        title:'Menu',
    }
];

