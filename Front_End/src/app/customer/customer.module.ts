import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { AddBillComponent } from './add-bill/add-bill.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AddCustomerComponent } from './add-customer/add-customer.component';


@NgModule({
  declarations: [RestaurantListComponent, EditCustomerComponent,  AddToCartComponent, PlaceOrderComponent, AddBillComponent, AddCustomerComponent],
  imports: [
    CommonModule,ReactiveFormsModule, HttpClientModule
  ],
  exports:[RestaurantListComponent, EditCustomerComponent,AddToCartComponent, PlaceOrderComponent, AddBillComponent,AddCustomerComponent]

})
export class CustomerModule { }
