import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { EditRestaurantComponent } from './edit-restaurant/edit-restaurant.component';
import { AddItemComponent } from './add-item/add-item.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AdminLoginComponent } from './admin-login/admin-login.component';


@NgModule({
  declarations: [AddRestaurantComponent, EditRestaurantComponent, AddItemComponent, AddCategoryComponent, CategoryListComponent, ItemListComponent, AdminLoginComponent],
  imports: [
    CommonModule,ReactiveFormsModule, HttpClientModule
  ],
  exports:[AddRestaurantComponent, EditRestaurantComponent, AddItemComponent, AddCategoryComponent, CategoryListComponent, ItemListComponent]
})
export class RestaurantAdminModule { }
