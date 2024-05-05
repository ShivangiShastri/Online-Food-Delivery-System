import { FoodCart } from "./FoodCart";

export class OrderDetails{
    orderId: number;
    orderStatus: string;
    cart : FoodCart;

    constructor(orderId: number, orderStatus: string, cart: FoodCart){
        this.orderId=orderId;
        this.orderStatus=orderStatus;
        this.cart=cart;
    }
}