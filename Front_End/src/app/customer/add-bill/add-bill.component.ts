import { HttpBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,

  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';
import { Bill } from 'src/app/model/Bill';
import { RestaurantAdminService } from 'src/app/restaurant-admin/restaurant-admin.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css'],
})
export class AddBillComponent implements OnInit {
  constructor(
    private service: CustomerService,
    private service1: RestaurantAdminService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  bills: Bill[] = new Array();
  billForm: FormGroup;
  submitted: boolean = false;
  orderId='';
  itemName = '';
  cost = '';
  quantity = '';
  categoryName = '';
  Item='';
  buildingName='';
  streetNo='';
  area='';
  city='';
  pincode='';

  ngOnInit(): void {

    this.orderId = localStorage.getItem('customerId');
    this.cost = localStorage.getItem('cost');
    this.quantity = localStorage.getItem('quantity');
    this.categoryName = localStorage.getItem('categoryName');
    this.itemName = localStorage.getItem('itemName');
    this.buildingName = localStorage.getItem('buildingName');
    this.streetNo = localStorage.getItem('streetNo');
    this.area = localStorage.getItem('area');
    this.city = localStorage.getItem('city');
    this.pincode = localStorage.getItem('pincode');


    this.billForm = this.fb.group({
      billId: [this.orderId, Validators.required],
      totalCost: [this.cost, Validators.required],
      totalItem: ['', Validators.required],
    });

   
  }

  addBill() {
    this.submitted = true;
    if (this.billForm.invalid) {
      return;
    }
    this.service.addBill(this.billForm.value).subscribe((data) => {
      alert('Thank You for Ordering!!!');

      /*  this.router.navigate(['view-bill']); */
      this.service1.getAllBills().subscribe((data) => {
        this.bills = data;
      });

    });
  }
    back(){
      this.router.navigate(['home']);
    }
  
}
