import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { Login } from '../model/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

 
 /*   private static customer:Customer[] =new Array();
  baseUrl :string ="http://localhost:3000/customers"; 

 */


  baseUrl :string ="http://localhost:9090/online-food-delivery-api/login";
  constructor(private http:HttpClient) { }

addUser(customer : Customer) : Observable<string>{
  return this.http.post(this.baseUrl, customer,{ 'responseType': 'text'});
}

login(login : Login): Observable<object>{
  return this.http.post(this.baseUrl + '/login', login);
}

 viewUser(){
  return this.http.get<Login[]>(this.baseUrl);
}
}
