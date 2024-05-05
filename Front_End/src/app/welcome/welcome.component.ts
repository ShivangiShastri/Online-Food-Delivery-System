import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantAdminService } from '../restaurant-admin/restaurant-admin.service';

@Component({
  selector: 'welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private router: Router, private service: RestaurantAdminService) { }
 userName ='';

 ngOnInit(): void {
    this.userName= localStorage.getItem('username');
 
  }

  
  restaurantList(){
    this.router.navigate(['restaurant-list']);
  }

  editCustomer(){
    this.router.navigate(['edit-customer']);
  }
  
}
