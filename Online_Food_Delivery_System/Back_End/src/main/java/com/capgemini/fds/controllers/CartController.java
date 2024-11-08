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

import com.capgemini.fds.entities.FoodCart;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.exceptions.FoodCartEmptyException;
import com.capgemini.fds.services.ICartService;

 

@RestController
@RequestMapping(path = "carts")
public class CartController {

 

    @Autowired
    private ICartService service;

    // http://localhost:/9090/OnlineFoodDeliveryApp/carts
    @PostMapping(consumes = "application/json")
    public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart cart, Item item) throws FoodCartEmptyException {

       FoodCart result = service.addItemToCart(cart, item);
        ResponseEntity<FoodCart> response = null;
        if (result != null) {
            response = new ResponseEntity<>(HttpStatus.CREATED);
            return response;
        }
        throw new FoodCartEmptyException("Your cart is empty");
    }

  //http://localhost:/9090/OnlineFoodDelivery/carts
    @GetMapping(produces = "application/json")
    public List<FoodCart> getCart(){
        List<FoodCart> result = service.viewCart();
        return result;
    }

    @ExceptionHandler(value = FoodCartEmptyException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Your cart is empty")
    public void NoSuchItemFound() {

 

    }

 

}