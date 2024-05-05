import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RestaurantAdminService } from '../restaurant-admin.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  itemForm: FormGroup;
  submitted: boolean=false;

  constructor(private service: RestaurantAdminService, private router: Router, private fb: FormBuilder){}
  ngOnInit(): void{
    this.itemForm = this.fb.group({
      itemId:['',Validators.required],
      itemName:['',Validators.required],
      cost:['',Validators.required],
      quantity:['',Validators.required],

      category : this.fb.group({
      categoryId:['',Validators.required]
      })
    });
  }
  addItem(){
    this.submitted = true;
    if(this.itemForm.invalid){
      return;
    }
    this.service.addItem(this.itemForm.value).subscribe(data=>{
      alert('Item added Successfully!!')
      localStorage.setItem("itemId",this.itemForm.controls.itemId.value);
      localStorage.setItem("itemName",this.itemForm.controls.itemName.value);
      localStorage.setItem("cost",this.itemForm.controls.cost.value);
      localStorage.setItem("quantity",this.itemForm.controls.quantity.value);
      localStorage.setItem("categoryName", data['category'].categoryName);
    });
      this.router.navigate(['add-restaurant']);
   
  }

  viewList(){
    this.router.navigate(['item-list']);
  }
}
