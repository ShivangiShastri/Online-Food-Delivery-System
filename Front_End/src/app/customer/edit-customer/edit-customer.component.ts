import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  editForm : FormGroup;
  submitted: boolean=false;
  
  constructor(private service: CustomerService,private router: Router, private formBuilder: FormBuilder) { }
  customer: any;
  id:number;
  ngOnInit() {
    if(localStorage.getItem("firstname")!=null){
    let userId = localStorage.getItem("customerId");
    if(!userId) {
      alert("Invalid action.")
      this.router.navigate(['welcome']);
      return;
    }
    this.editForm= this.formBuilder.group({
      customerId: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      mobileNumber: ['', Validators.required],
      email: ['', Validators.required],
      gender: ['', Validators.required],
      age: ['', Validators.required],
     
      address :this.formBuilder.group({
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

    /* this.service.getUserById(+userId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
    }
    else
        this.router.navigate(['/login']);
  }

  onSubmit() {
    this.submitted = true;
    if(this.editForm.invalid){
      alert('invalid editform');
      return;
    }
    this.service.updateUser(this.editForm.value)
      .subscribe(
        data => {
          this.router.navigate(['list-user']);
        },
        error => {
          alert('error: '+error.url);
        }); */
  }


 

  }
}
