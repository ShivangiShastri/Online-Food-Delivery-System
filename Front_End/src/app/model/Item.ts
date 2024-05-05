import {Category} from "./Category"

export class Item{
    itemId: number;
    itemName: string;
    cost: number;
    quantity: number;
    category: Category;

    constructor(itemId: number, itemName: string, cost: number, quantity: number,category: Category){
        this.itemId=itemId;
        this.itemName=itemName;
        this.cost=cost;
        this.quantity=quantity;
        this.category=category;
    }
}