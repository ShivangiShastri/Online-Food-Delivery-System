import { Customer } from "./customer";

export class Login{
    
    userid: number;
    userName: string;
    password: string;
    customer: Customer

    constructor(userid: number, userName: string, password: string, customer: Customer){
        this.userid =userid;
        this.userName=userName;
        this.password=password;
        this.customer=customer;
    }
}