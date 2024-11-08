package com.capgemini.fds.services;

import java.util.List;

import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateRestaurantException;

public interface IRestaurantService {

	public Restaurant addRestaurant(Restaurant res) throws DuplicateRestaurantException;
	public Restaurant removeRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res);
	public  List<Restaurant> viewAllRestaurants();
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);
}