import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from '../model/Bill';
import { Customer } from '../model/customer';
import { FoodCart } from '../model/FoodCart';
import { Item } from '../model/Item';
import { OrderDetails } from '../model/OrderDetails';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  
  baseUrl :string ="http://localhost:9090/online-food-delivery-api/customers";
  constructor(private http:HttpClient) { }

  addCustomer(customer : Customer) : Observable<object>{
    return this.http.post(this.baseUrl, customer);
   }
   getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl);
  }
  viewCustomerById(id: number){
    const url = this.baseUrl + `${id}`;
    let customers= this.http.get(url);
    //return this.http.get<Customer>(this.baseUrl);
    return customers;
  }
  
  baseUrlCart : string="http://localhost:9090/online-food-delivery-api/carts";

  addItemtoCart(carts: FoodCart): Observable<string>{
    return this.http.post(this.baseUrlCart, carts, {'responseType': 'text'});
  }
  getCart(): Observable<FoodCart[]>{
    return this.http.get<FoodCart[]>(this.baseUrlCart);
  }

  getCartDetails(cart : FoodCart): Observable<FoodCart>{
    return this.http.get<FoodCart>(this.baseUrlCart);
  }
  baseUrlOrder : string= "http://localhost:9090/online-food-delivery-api/orders";
  addOrder(orders: OrderDetails){
    return this.http.post(this.baseUrlOrder,orders);
  }

  
  baseUrlBill : string ="http://localhost:9090/online-food-delivery-api/bills";
  addBill(bill : Bill){
    return this.http.post(this.baseUrlBill, bill);
  }
  getAllBills(): Observable<Bill[]> {
    return this.http.get<Bill[]>(this.baseUrlBill);
  }

  baseUrlItem : string ="http://localhost:9090/online-food-delivery-api/items";
  getAllItems(): Observable<Item[]>{
    return this.http.get<Item[]>(this.baseUrlItem);

  }

}
