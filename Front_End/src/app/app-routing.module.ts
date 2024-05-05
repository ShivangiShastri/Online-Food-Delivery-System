import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBillComponent } from './customer/add-bill/add-bill.component';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { AddToCartComponent } from './customer/add-to-cart/add-to-cart.component';
import { PlaceOrderComponent } from './customer/place-order/place-order.component';
import { RestaurantListComponent } from './customer/restaurant-list/restaurant-list.component';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './login/sign-in/sign-in.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';
import { AddCategoryComponent } from './restaurant-admin/add-category/add-category.component';
import { AddItemComponent } from './restaurant-admin/add-item/add-item.component';
import { AddRestaurantComponent } from './restaurant-admin/add-restaurant/add-restaurant.component';
import { AdminLoginComponent } from './restaurant-admin/admin-login/admin-login.component';
import { CategoryListComponent } from './restaurant-admin/category-list/category-list.component';
import { EditRestaurantComponent } from './restaurant-admin/edit-restaurant/edit-restaurant.component';
import { ItemListComponent } from './restaurant-admin/item-list/item-list.component';
import { WelcomeComponent } from './welcome/welcome.component';


const routes: Routes = [
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path : 'home', component: HomeComponent},
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent },
  {path: 'admin-login', component:AdminLoginComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'add-customer', component: AddCustomerComponent},
  { path: 'restaurant-list', component: RestaurantListComponent },
  { path: 'add-to-cart', component: AddToCartComponent },
  { path: 'place-order', component: PlaceOrderComponent },
  { path: 'add-bill', component: AddBillComponent },
  { path: 'add-category', component: AddCategoryComponent },
  { path: 'add-item', component: AddItemComponent },
  { path: 'add-restaurant', component: AddRestaurantComponent },
  { path: 'edit-restaurant', component: EditRestaurantComponent },
  { path: 'category-list', component: CategoryListComponent },
  { path: 'item-list', component: ItemListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
