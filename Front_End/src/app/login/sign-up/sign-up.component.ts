import { Component, Input, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/Login';
import { LoginService } from '../login.service';

@Component({
  selector: 'sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
  @Input() num: number;
  users: Login;
  loginForm: FormGroup;
  submitted: boolean = false;

  constructor(
    private service: LoginService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      userid: ['', Validators.required],
      userName: ['', Validators.required],
      password: ['', Validators.required],

      customer: this.fb.group({
        customerId: ['', Validators.required],
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        mobileNumber: ['', Validators.required],
        email: ['', Validators.required],
        gender: ['', Validators.required],
        age: ['', Validators.required],

        address: this.fb.group({
          addressId: ['', Validators.required],
          buildingName: ['', Validators.required],
          area: ['', Validators.required],
          streetNo: ['', Validators.required],
          city: ['Pune', Validators.required],
          state: ['MH', Validators.required],
          country: ['India', Validators.required],
          pincode: ['', Validators.required],
        }),
      }),
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      alert('Successfully');
      return;
    }

    this.service.addUser(this.loginForm.value).subscribe((data) => {
      alert('Customer is registered successfully');
    }
    );    
    // this will redirect you to another component
    this.router.navigate(['sign-in']);
  } 
  viewUserId() {
    this.service.viewUser();
  }
}
