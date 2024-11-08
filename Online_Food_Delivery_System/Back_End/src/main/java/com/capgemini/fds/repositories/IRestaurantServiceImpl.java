package com.capgemini.fds.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateRestaurantException;
import com.capgemini.fds.repositories.IRestaurantRepository;

@Service("restaurantservice")
public class IRestaurantServiceImpl implements IRestaurantService {
	@Autowired
	private IRestaurantRepository repository;

	public IRestaurantServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Restaurant addRestaurant(Restaurant restaurant) throws DuplicateRestaurantException {
		if (validateRestaurant(restaurant)) {
			try {
				Restaurant result = repository.save(restaurant);
				return (result.getRestaurantId() > 0) ? result : null;

			} catch (ConstraintViolationException e) {
				throw new DuplicateRestaurantException("Restaurant already exixts");
			}
		}
		return restaurant;
	}

	public Restaurant removeRestaurant(Restaurant restaurant) {

		return null;
	}

	public Restaurant updateRestaurant(Restaurant restaurant) {

		return null;
	}

	public List<Restaurant> viewAllRestaurants() {

		return repository.findAll();
	}

	public List<Restaurant> viewNearByRestaurant(String location) {

		return null;
	}

	public List<Restaurant> viewRestaurantByItemName(String name) {

		return null;
	}

	private boolean validateRestaurant(Restaurant restaurant) {
		if (!restaurant.getRestaurantName().matches("[A-Za-z]+")) {
			return false;
		}
		return true;
	}

}
/*
 * @Override public Restaurant findRestaurantById(int restaurantId) throws
 * NoSuchRestaurantException { Optional<Restaurant> result =
 * repository.findById(restaurantId); Restaurant restaurant;
 * if(result.isPresent()) { restaurant = result.get(); } else { throw new
 * NoSuchRestaurantException("No Restaurant Found"); } return restaurant;
 * 
 * }
 */