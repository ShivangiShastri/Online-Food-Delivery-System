import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Item } from 'src/app/model/Item';
import { RestaurantAdminService } from '../restaurant-admin.service';


@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
items: Item[] = new Array();
itemForm: FormGroup;
submitted: boolean=false;
  constructor(private service: RestaurantAdminService, private router: Router, private fb: FormBuilder) { }

  ngOnInit(){
  
  }
  viewAllItems(){
  this.service.getAllItems().subscribe((data) => {
    this.items = data;
});
}
back(){
  this.router.navigate(['add-item']);
}
}