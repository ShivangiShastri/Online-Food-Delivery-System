import { OrderDetails } from "./OrderDetails";

export class Bill{
    billId: number;
    totalItem: number;
    totalCost: number;
    order :OrderDetails;

    constructor(billId: number, totalItem : number, totalCost: number, order: OrderDetails){
        this.billId=billId;
        this.totalItem=totalItem;
        this.totalCost=totalCost;
        this.order=order;
    }
}