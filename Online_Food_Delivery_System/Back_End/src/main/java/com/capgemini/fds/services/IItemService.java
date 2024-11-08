package com.capgemini.fds.services;

import java.util.List;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateItemException;
import com.capgemini.fds.exceptions.NoSuchItemFoundException;

public interface IItemService {

	public Item addItem(Item item) throws DuplicateItemException;
	public Item viewItem(String id);
	public Item updateItem(Item item);
	public Item removeItem(String id);
	public List<Item> viewAllItems(Restaurant res);
	public List<Item> viewAllItems(Category cat);
	public List<Item> viewAllItemsByName(String name);
	public List<Item> viewAllItems();
	Item viewItem(int id) throws NoSuchItemFoundException;
	
}