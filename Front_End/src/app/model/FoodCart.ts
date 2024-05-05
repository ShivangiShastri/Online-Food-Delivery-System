import { Customer } from './customer';
import { Item } from './Item';

export class FoodCart {
  cartId: number;
  items: Item;
  customer: Customer;

  constructor(cartId: number, items: Item, customer: Customer) {
    this.cartId = cartId;
    this.items = items;
    this.customer = customer;
  }
}
