import {Address} from "./Address"

export class Customer{
    customerId: number;
    firstName: string;
    lastName: string;
    mobileNumber: string;
    email: string;
    gender: string;
    age: string; 
    address : Address;
    
    constructor(customerId: number, firstName: string, lastName: string, mobileNumber: string, email: string, gender : string, age:string, address: Address){
        this.customerId=customerId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobileNumber=mobileNumber;
        this.email=email;
        this.gender=gender;
        this.age=age;
        this.address=address;
    }
}