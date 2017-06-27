package com.niit.shopperBackend.dao;

import java.util.List;

import com.niit.shopperBackend.dto.Address;
import com.niit.shopperBackend.dto.Cart;
import com.niit.shopperBackend.dto.User;

public interface UserDAO {

	
	boolean addUser(User user);
	
     User getByEmail(String email);
	
	boolean addAddress(Address address);
	//Alternative way
	//Address getByBillingAddress(int userId);
	//List<Address> listShippingAddress(int userId); 
	
	Address getByBillingAddress(User user);
	List<Address> listShippingAddress(User user); 
	
	
	///initially addCart then after necessary change update cart
	boolean updateCart(Cart cart);
	
}
