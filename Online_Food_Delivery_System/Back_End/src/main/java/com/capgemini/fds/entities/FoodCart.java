package com.capgemini.fds.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("foodcart")
@Scope("prototype")
@Entity
@Table(name = "FOOD_CART")
public class FoodCart {
    @Id
    @Column(name = "CART_ID")
  //  @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    /*
     * @Column(name = "ITEM_LIST")
     * 
     * @NotNull private List<Item> itemList;
     */
    @Autowired
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ITEM_ID")
    private Set<Item> items ;
   
    public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	public FoodCart(Set<Item> items) {
		this.items = items;
	}


	@Autowired
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
    // Setter injection
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // Constructor injection
    public FoodCart(Customer customer) {
        this.customer = customer;
    }
    public FoodCart() {

    }

    public FoodCart(int cartId, Customer customer, Set<Item> items) {
        super();
        this.cartId = cartId;
        this.customer = customer;
        this.items = items;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", items=" + items + "]";
    }

 

}