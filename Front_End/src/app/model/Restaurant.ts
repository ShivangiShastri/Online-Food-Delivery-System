import { Address } from "./Address";
import { Item } from "./Item";

export class Restaurant{
    restaurantId: number;
    restaurantName: string;
    managerName: string;
    contactNumber: string;
    address: Address;
    items: Item;

    constructor(restaurantId: number, restaurnatName: string, managerName: string, contactNumber: string,address: Address, items:Item){
        this.restaurantId= restaurantId;
        this.restaurantName= restaurnatName;
        this.managerName=managerName;
        this.contactNumber=contactNumber;
        this.address=address;
        this.items=items;
    }
}