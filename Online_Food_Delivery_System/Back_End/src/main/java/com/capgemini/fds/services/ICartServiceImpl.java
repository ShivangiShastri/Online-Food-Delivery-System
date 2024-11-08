package com.capgemini.fds.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.FoodCart;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.exceptions.FoodCartEmptyException;
import com.capgemini.fds.repositories.ICartRepository;

@Service("cartservice")
public class ICartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository repository;

	@Override
	@Transactional
	public FoodCart addItemToCart(FoodCart cart, Item item) throws FoodCartEmptyException {
		if (validateCart(cart)) {
			try {
				FoodCart result = repository.save(cart);
				return (result.getCartId() > 0) ? result : null;
			} catch (ConstraintViolationException e) {
				throw new FoodCartEmptyException("Your cart is empty");
			}
		}
		return cart;
	}

	private boolean validateCart(FoodCart cart) {

		if (cart.getCartId() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<FoodCart> viewCart() {
		return repository.findAll();
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) {
		// TODO Auto-generated method stub
		return null;
	}

}