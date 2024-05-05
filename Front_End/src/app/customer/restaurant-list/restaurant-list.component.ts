import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/model/Restaurant';
import { RestaurantAdminService } from 'src/app/restaurant-admin/restaurant-admin.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

  restaurants: Restaurant[] = new Array();
  constructor(private service: RestaurantAdminService, private router: Router) { }

  ngOnInit(): void {


  }
  viewRestaurants() {
    this.service.getAllRestaurants().subscribe((data) => {
      this.restaurants = data;
    });
  }
  addToCart(){
    this.router.navigate(['add-to-cart'])

  }
  logout(){
    this.router.navigate(['welcome']);
  }

}
