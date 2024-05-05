import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/model/Restaurant';
import { RestaurantAdminService } from '../restaurant-admin.service';

@Component({
  selector: 'app-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styles: [`input[type="text"]:focus {
    background-color: lightblue;
    box-sizing: border-box;
  
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    padding: 12px 20px;
    display: inline-block;
    width: 100%;
  }
  th{
    background-color: lightgray;
    color: black;
}
  body {
    background-image: url("/assets/images/brownie.jpeg");
    background-position: center;
  
    background-size: cover;
  }
  
  .container {
    width: 600px;
    opacity: 0.8;
  }
  
  input[type="submit"] {
    width: 120px;
    background-color: #4caf50;
    color: white;
    padding: 10px 18px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  .center {
    margin: 0;
    top: 50%;
    left: 50%;
    }
  
  
  
  input[type="submit"]:hover {
    background-color: #45a049;
  }
  
  div {
    border-radius: 5px;
    background-color: #e6e2d3;
    padding: 5px;
  }
  legend {
    background-color: #000;
    color: #fff;
    padding: 3px 6px;
  }
  
  fieldset {
    width: inherit; /* Or auto */
    padding: 0 10px; /* To give a bit of padding on the left and right */
    border-bottom: none;
  }
  
  .output {
    font: 1rem "Fira Sans", sans-serif;
  }
  
  label {
    margin-left: 0px;
    font-weight: bold;
  }
  
  .container-fluid {
    width: 100%;
  }
  
  h3 {
    margin-left: 0px;
  }
  
  input {
    margin: 0.4rem;
    width: 100%;
    display: inline-block;
    margin-left: 0px;
    border: 1px solid black;
  }
  
  .form {
    margin: 0 auto;
    width: 400px;
    opacity: 0.1;
  }
  
  /* .form label{
    display: inline-block;
    text-align: center;
    
  }
  
  .form input{
    display: inline-block;
    text-align: left;
    
  } */
  `
  ]
})
export class AddRestaurantComponent implements OnInit {

  restaurantForm: FormGroup;
  submitted: boolean = false;
  restaurants: Restaurant[] = new Array();

  constructor(private service: RestaurantAdminService, private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.restaurantForm = this.fb.group({
      restaurantId: ['', Validators.required],
      restaurantName: ['', Validators.required],
      managerName: ['', Validators.required],
      contactNumber: ['', Validators.required],

      address:this.fb.group({
        addressId: ['',Validators.required],
        area: ['',Validators.required],
        buildingName:['',Validators.required],
        city: ['',Validators.required],
        country: ['',Validators.required],
        pincode:['',Validators.required],
        state:['',Validators.required],
        streetNo:['',Validators.required]
  }),
      items:this.fb.group({
        
         itemId:['',Validators.required]   
       }),
    });

  }

  addRestaurant() {
    this.submitted = true;
    if (this.restaurantForm.invalid) {
      return;
    }

    this.service.addRestaurant(this.restaurantForm.value).subscribe(data => {
      alert("Restaurant is added successfully.");

      this.service.getAllRestaurants().subscribe((data) => {
        this.restaurants = data;
      });
    });
    
  }

  back(){
    this.router.navigate(['home']);
  }

}