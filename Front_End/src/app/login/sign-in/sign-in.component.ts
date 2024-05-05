import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css'],
})
export class SignInComponent implements OnInit {
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private service: LoginService
  ) {}
  loginForm: FormGroup;
  submitted: boolean = false;
  invalidLogin: boolean = false;

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userid: ['', Validators.required],
      userName: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  login() {
    this.router.navigate(['welcome']);
  }
  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      alert('Successfully');
      return;
    }
  

    this.service.login(this.loginForm.value).subscribe(
      (data) => {
       
        localStorage.setItem("customerId", data['customer'].customerId);
        localStorage.setItem("userid",this.loginForm.controls.userid.value);
        localStorage.setItem("username", this.loginForm.controls.userName.value);
        localStorage.setItem("buildingName", data['customer']['address'].buildingName);
        localStorage.setItem("streetNo", data['customer']['address'].streetNo);
        localStorage.setItem("area",data['customer']['address'].area);
        localStorage.setItem("city", data['customer']['address'].city);
        localStorage.setItem("pincode", data['customer']['address'].pincode);
        
        this.router.navigate(['welcome']);
      },
      (error) => {
        alert('Username or password is invalid');
      }
    );
  }
}

/* {
   this.service.addCustomer(this.loginForm.value).subscribe((data) => {
     alert('Customer is logged-in successfully');
   });

   // this will redirect you to another component
   this.router.navigate(['customer']);
 } else {
   
   alert('Cannot enter null value');
 }
} 
 validateAdmin(form: any) {
   let data = form.value;
   let observable: Observable<Login> = this.service.validateAdmin(data.username, data.password);
   // observable.subscribe((retrieveAdmin:any)=>this.sendData(retrieveAdmin), err=> alert("wrong username and password"));
 } */
