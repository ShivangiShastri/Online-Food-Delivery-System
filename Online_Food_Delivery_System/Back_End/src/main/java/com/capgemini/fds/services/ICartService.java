package com.capgemini.fds.services;


import java.util.List;

import com.capgemini.fds.entities.FoodCart;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.exceptions.FoodCartEmptyException;

public interface ICartService {

	public FoodCart addItemToCart(FoodCart cart, Item item) throws FoodCartEmptyException;

	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity);

	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity);

	public FoodCart removeItem(FoodCart cart, Item item);

	public FoodCart clearCart(FoodCart cart);
	
	public List<FoodCart> viewCart();

}