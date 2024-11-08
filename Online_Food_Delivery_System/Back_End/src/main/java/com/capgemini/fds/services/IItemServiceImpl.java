package com.capgemini.fds.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateItemException;
import com.capgemini.fds.exceptions.NoSuchItemFoundException;
import com.capgemini.fds.repositories.ICategoryRepository;
import com.capgemini.fds.repositories.IItemRepository;

@Service("itemservice")
public class IItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepository repository;

	@Autowired
	private ICategoryRepository catrepository;

	@Override
	@Transactional
	public Item addItem(Item item) throws DuplicateItemException {
		System.out.println(item);
		if (validateItem(item)) {
			try {
				// System.out.println("Category : " + item.getCategory());
				// Category cat = catrepository.save(item.getCategory());
				Item result = repository.save(item);
				return (result.getItemId() > 0) ? result : null;
			} catch (ConstraintViolationException e) {
				throw new DuplicateItemException("Item already exists in cart");
			}
		}

		return item;
	}

	private boolean validateItem(Item item) {
		if (!item.getItemName().matches("[A-Za-z]+")) {
			return false;
		} else if (item.getQuantity() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public Item viewItem(int id) throws NoSuchItemFoundException{
		Optional<Item> result = repository.findById(id);
		
		Item item = null;
		if(result.isPresent()) {
			item = result.get();
		}else {
			throw new NoSuchItemFoundException("Item not found");
		}
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item removeItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItems(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public List<Item> viewAllItems() {
        return repository.findAll();
    }

	@Override
	public Item viewItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}