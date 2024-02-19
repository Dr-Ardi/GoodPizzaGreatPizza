import { Routes } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { MenuComponent } from './menu-screen/menu/menu.component';
import { ItemDetailsComponent } from './item-details/item-details.component';

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
    },
    {
        path: 'item/:id',
        component: ItemDetailsComponent,
        title: 'Item details'
    }
];

