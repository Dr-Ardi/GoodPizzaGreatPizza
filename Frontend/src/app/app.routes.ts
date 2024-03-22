import { Routes } from '@angular/router';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { MenuComponent } from './menu-screen/menu/menu.component';
import { ItemDetailsComponent } from './item-details-screen/item-details/item-details.component';
import { MyOrderComponent } from './order-screen/my-order/my-order.component';
import { RestaurantComponent } from './restaurant/restaurant.component';

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
        path: 'order',
        component: MyOrderComponent,
        title: 'My Order'
    },
    {
        path: 'item/:id',
        component: ItemDetailsComponent,
        title: 'Item details'
    },
    {
        path: 'restaurant',
        component: RestaurantComponent,
        title: 'Restaurant Screen'
    }
];

