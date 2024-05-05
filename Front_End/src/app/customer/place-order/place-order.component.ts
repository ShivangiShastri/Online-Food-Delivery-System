import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { OrderDetails } from 'src/app/model/OrderDetails';
import { RestaurantAdminService } from 'src/app/restaurant-admin/restaurant-admin.service';
import { CustomerModule } from '../customer.module';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styles: [],
})
export class PlaceOrderComponent implements OnInit {
  orderForm: FormGroup;
  submitted: boolean = false;
  orders: OrderDetails[] = new Array();
  orderId='';
  itemName = '';
  cost = '';
  quantity = '';
  categoryName = '';
  constructor(
    private service: CustomerService,
    private service1: RestaurantAdminService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.orderId = localStorage.getItem('customerId');
    this.cost = localStorage.getItem('cost');
    this.quantity = localStorage.getItem('quantity');
    this.categoryName = localStorage.getItem('categoryName');
    this.itemName = localStorage.getItem('itemName');
  }

  viewBill(){
    this.router.navigate(['add-bill']);
  }
}
;