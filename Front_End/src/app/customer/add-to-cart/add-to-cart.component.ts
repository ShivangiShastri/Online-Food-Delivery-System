import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Bill } from 'src/app/model/Bill';
import { FoodCart } from 'src/app/model/FoodCart';
import { Item } from 'src/app/model/Item';
import { RestaurantAdminService } from 'src/app/restaurant-admin/restaurant-admin.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css'],
})
export class AddToCartComponent implements OnInit {
  cartForm: FormGroup;
  submitted: boolean = false;
  carts: FoodCart[] = new Array();
  cart :FoodCart;
bill : Bill;
userName='';
customerid='';
items: Item[] = new Array();

  constructor(
    private service: CustomerService,
    private router: Router,
    private fb: FormBuilder,
    private service1: RestaurantAdminService,
  ) {}
 
  ngOnInit(): void {
    this.customerid= localStorage.getItem('customerId');
    this.userName= localStorage.getItem('username');

    this.service1.getAllItems().subscribe((data) => {
      this.items = data;
  });

    this.cartForm = this.fb.group({
      cartId: [this.customerid, Validators.required],

      customer: this.fb.group({
        customerId: [this.customerid, Validators.required],
      }),
      items: this.fb.group({
        itemId: ['', Validators.required]
        
      }),
    });

  }
  addItemtoCart() {
    this.submitted = true;
    if (this.cartForm.invalid) {
      return;
    }

    this.service.addItemtoCart(this.cartForm.value).subscribe(
      (data) => {

      localStorage.setItem("cartId",this.cartForm.controls.cartId.value);
      localStorage.setItem("itemName",data['items'].itemName);
    });

    
   this.router.navigate(['place-order']);
  }
  viewCart(){
    this.service.getCart().subscribe((data) => {
      this.carts = data;
    });

  }

  viewList(){
    
  
}
}
