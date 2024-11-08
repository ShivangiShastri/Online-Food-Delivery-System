package com.capgemini.fds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.fds.entities.Item;
import com.capgemini.fds.exceptions.DuplicateItemException;
import com.capgemini.fds.services.IItemService;

@RestController
@RequestMapping(path="items")
public class ItemController {
	
	@Autowired
	private IItemService service;

	//http://localhost:9090/OnlineFoodDeliveryApp/items
	@PostMapping(consumes="application/json")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws DuplicateItemException{
		
		Item result = service.addItem(item);
		ResponseEntity<Item> response = null;
		if(result !=null) {
			response = new ResponseEntity<>(HttpStatus.CREATED);
			return response;
		}
		throw new DuplicateItemException("Item already exists in cart");
		
	}
	
	//http://localhost:9090/OnlineFoodDeliveryApp/items
    @GetMapping(produces = "application/json")
    public List<Item> getAllItems(){
        List<Item> result = service.viewAllItems();
        return result;
    }
	
	
	@ExceptionHandler(value = DuplicateItemException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason="Item already exists in cart")
	public void NoSuchItemFound() {
		
	}
	
	
}