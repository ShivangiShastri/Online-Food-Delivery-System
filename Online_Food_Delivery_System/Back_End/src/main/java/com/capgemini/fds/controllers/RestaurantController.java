package com.capgemini.fds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateRestaurantException;
import com.capgemini.fds.exceptions.NoSuchRestaurantException;
import com.capgemini.fds.services.IRestaurantService;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {
	@Autowired
	private IRestaurantService service;

	// http://localhost:9090/OnlineFoodDeliveryApp/restaurants
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant)
			throws DuplicateRestaurantException {
		Restaurant result = service.addRestaurant(restaurant);
		ResponseEntity<Restaurant> response = null;
		if (result !=null) {
			response = new ResponseEntity<Restaurant>(HttpStatus.CREATED);
			return response;
		}
		throw new DuplicateRestaurantException("Restaurant already exists.");

	}

	@GetMapping(produces = "application/json")
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> result = service.viewAllRestaurants();
		return result;
	}

	@ExceptionHandler(value = DuplicateRestaurantException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Restaurant already exists")
    public void handeDuplicateRestaurant() {

 

    }
	/*
	 * @PostMapping(consumes = "application/json") public ResponseEntity<Restaurant>
	 * addRestaurant(@RequestBody Restaurant restaurant) throws
	 * DuplicateRestaurantException, NoSuchRestaurantException { if
	 * (service.findRestaurantById(restaurant.getRestaurantId()) == null) { boolean
	 * result = service.addRestaurant(restaurant); ResponseEntity<Restaurant>
	 * response; if (result) { response = new
	 * ResponseEntity<Restaurant>(HttpStatus.OK); return response; } } throw new
	 * DuplicateRestaurantException("Duplicate Entries Are Not ALlowed To Be Inserted"
	 * ); }
	 */
}