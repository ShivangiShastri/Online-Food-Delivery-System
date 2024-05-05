import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css'],
})
export class AddCustomerComponent implements OnInit {
  
  customers: Customer[] = new Array();
  customerForm: FormGroup;
  submitted: boolean=false;

  constructor(private service: CustomerService, private router: Router,private fb: FormBuilder) {}

  ngOnInit() {
    this.customerForm = this.fb.group({
      customerId: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      mobileNumber: ['', Validators.required],
      email: ['', Validators.required],
      gender: ['', Validators.required],
      age: ['', Validators.required],
     
      address :this.fb.group({
      addressId: ['', Validators.required],
      buildingName: ['', Validators.required],
      area: ['', Validators.required],
      streetNo: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      country: ['', Validators.required],
      pincode: ['', Validators.required]
    })
    });

  
  }

  addCustomer() {
    this.submitted = true;
    if(this.customerForm.invalid){
      return;
    }
    this.service.addCustomer(this.customerForm.value).subscribe(data => {
      alert('Customer is added successfully');
    });
    
    this.router.navigate(['sign-in']);
  } 

  viewCustomer(){
    this.service.getAllCustomers().subscribe((data) => {
      this.customers = data;
    });
  }
}
