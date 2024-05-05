import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/model/Category';
import { RestaurantAdminService } from '../restaurant-admin.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  categoryForm : FormGroup;
  submitted: boolean = false;

  constructor(private service: RestaurantAdminService, private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.categoryForm =  this.fb.group({
      categoryId: ['',Validators.required],
      categoryName: ['',Validators.required]
    });

  }

  addCategory() {
    this.submitted = true;
    if(this.categoryForm.invalid){
      return;
    }
    this.service.addCategory(this.categoryForm.value).subscribe(data => {
      alert('Category added successfully');
    });
      this.router.navigate(['add-item']);

   
  }

  viewCategory(){
    this.router.navigate(['category-list']);
  }

}
