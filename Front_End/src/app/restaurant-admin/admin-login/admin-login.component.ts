import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean = false;
  invalidLogin: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router) { }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      alert('Admin Logged in successfully...');
      return;
    }
    if (this.loginForm.controls.email.value == "door.delights@gmail.com" &&
      this.loginForm.controls.password.value == "admin") {
      // add email in the local storage 
      localStorage.setItem("username", this.loginForm.controls.email.value);
      // this will redirect you to another component
      this.router.navigate(['add-category']);
    }
    else {
      this.invalidLogin = true;
    }
  }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
}