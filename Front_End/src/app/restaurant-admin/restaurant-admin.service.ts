import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from '../model/Bill';
import { Category } from '../model/Category';
import { Item } from '../model/Item';
import { OrderDetails } from '../model/OrderDetails';
import { Restaurant } from '../model/Restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantAdminService {


  //baseUrl:string ="http://localhost:3000/category";

  baseUrlCategory: string = "http://localhost:9090/online-food-delivery-api/categories ";
  constructor(private http:HttpClient) { }

  addCategory(categories: Category){
    return this.http.post(this.baseUrlCategory, categories);
  }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.baseUrlCategory);
  }

 baseUrlRestaurant: string= "http://localhost:9090/online-food-delivery-api/restaurants";
 addRestaurant(restaurants: Restaurant) {
  //alert(JSON.stringify(restaurants));
  return this.http.post(this.baseUrlRestaurant, restaurants);
}

  getAllRestaurants():Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.baseUrlRestaurant);
  }

  baseUrlItem : string ="http://localhost:9090/online-food-delivery-api/items";
  addItem(items: Item){
    return this.http.post(this.baseUrlItem+'/', items);
  }

  getAllItems(): Observable<Item[]>{
    return this.http.get<Item[]>(this.baseUrlItem);

  }
  baseUrlOrder : string= "http://localhost:9090/online-food-delivery-api/orders";
  getAllOrdersDetails(): Observable<OrderDetails[]> {
    return this.http.get<OrderDetails[]>(this.baseUrlOrder);
  }

  baseUrlBill : string ="http://localhost:9090/online-food-delivery-api/bills";
  getAllBills(): Observable<Bill[]> {
    return this.http.get<Bill[]>(this.baseUrlBill);
  }
 }