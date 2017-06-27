package com.niit.shopper.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shopper.model.RegisterModel;
import com.niit.shopperBackend.dao.UserDAO;
import com.niit.shopperBackend.dto.Address;
import com.niit.shopperBackend.dto.Cart;
import com.niit.shopperBackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		
	registerModel.setUser(user);	
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		
		registerModel.setBilling(billing);	
		}
	
	public String saveAll(RegisterModel model){
		
		String transitionValue="success";
		
		//fetch the user
		User user=model.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save the user
		
		userDAO.addUser(user);
		
		//get address
		
		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
}
