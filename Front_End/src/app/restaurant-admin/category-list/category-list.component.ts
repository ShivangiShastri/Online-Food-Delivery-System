import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer/customer.service';
import { Category } from 'src/app/model/Category';
import { RestaurantAdminService } from '../restaurant-admin.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = new Array();
  categoryForm : FormGroup;
  submitted: boolean = false;
 

  constructor(private service: RestaurantAdminService, private router: Router,private fb: FormBuilder) { }

  ngOnInit(){
  }

  viewCategory(){
    this.service.getAllCategories().subscribe((data) => {
      this.categories = data;
    });
  }

  back(){
    this.router.navigate(['add-category']);
  }
}