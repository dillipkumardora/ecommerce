package com.niit.shopperBackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopperBackend.dao.UserDAO;
import com.niit.shopperBackend.dto.Address;
import com.niit.shopperBackend.dto.Cart;
import com.niit.shopperBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;

	private static User user =null;
	
	private static Cart cart =null;
	
	private static Address address =null;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopperBackend");
		context.refresh();
		
		userDAO =(UserDAO)context.getBean("userDAO");
	}
/*	
	@Test
	public void testAdd(){
		
		
		user=new User();
		user.setFirstName("arun");
		user.setLastName("dora");
		user.setEmail("arun@gmail.com");
		user.setContactNo("9247242947");
		user.setRole("USER");
		user.setPassword("dillip1994");
		
		assertEquals("Failed To ADD User!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("AT-NILACHAKRANAGAR,PO-GOPINATH PUR");
		address.setAddressLineTwo("PURI-2,PURI");
		address.setCity("puri");
		address.setState("orissa");
		address.setCountry("india");
		address.setPostalCode("752002");
		address.setBilling(true);
		
		//link user with the address
		
		address.setUserId(user.getId());
		
		assertEquals("Failed To ADD address!",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals(user)){
			
			//create cart for user
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("Failed To ADD cart!",true,userDAO.addCart(cart));
			
			//add a shipping address for the user

			address = new Address();
			address.setAddressLineOne("AT-ATHARNALA");
			address.setAddressLineTwo("PURI-2,PURI");
			address.setCity("CTC");
			address.setState("orissa");
			address.setCountry("india");
			address.setPostalCode("752006");
			//set shipping to be true
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
	@Test
	public void testAdd(){
		
		
		user=new User();
		user.setFirstName("arun");
		user.setLastName("dora");
		user.setEmail("arun@gmail.com");
		user.setContactNo("9247242947");
		user.setRole("USER");
		user.setPassword("dillip1994");
		
		assertEquals("Failed To ADD User!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("AT-NILACHAKRANAGAR,PO-GOPINATH PUR");
		address.setAddressLineTwo("PURI-2,PURI");
		address.setCity("puri");
		address.setState("orissa");
		address.setCountry("india");
		address.setPostalCode("752002");
		address.setBilling(true);
		
		//link user with the address
		
		address.setUserId(user.getId());
		
		assertEquals("Failed To ADD address!",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals(user)){
			
			//create cart for user
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("Failed To ADD cart!",true,userDAO.addCart(cart));
			
			//add a shipping address for the user

			address = new Address();
			address.setAddressLineOne("AT-ATHARNALA");
			address.setAddressLineTwo("PURI-2,PURI");
			address.setCity("CTC");
			address.setState("orissa");
			address.setCountry("india");
			address.setPostalCode("752006");
			//set shipping to be true
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			assertEquals("Failed To ADD shipping address!",true,userDAO.addAddress(address));

			
			
		}
	
	}
			
			
		}
	
	}
	*/
	
/*	
	
	@Test
	public void testAdd(){
		
		
		user=new User();
		user.setFirstName("arun");
		user.setLastName("dora");
		user.setEmail("arun@gmail.com");
		user.setContactNo("9247242947");
		user.setRole("USER");
		user.setPassword("dillip1994");
	
		if(user.getRole().equals("USER")){
			
			//create cart for user
			cart = new Cart();
			cart.setUser(user);
			
			//add cart to user
			user.setCart(cart);
			
			assertEquals("Failed To ADD user!",true,userDAO.addUser(user));

		}
	
	}
	
	*/
	
	
/*	@Test
	public void testUpdateCart(){
		
		//fetch the user by email
		user = userDAO.getByEmail("arun@gmail.com");
		
		//get the cart of the user
		
		cart =user.getCart();
		
		cart.setGrandTotal(999999);
		cart.setCartLines(2);
		assertEquals("Failed To update cart!",true,userDAO.updateCart(cart));

		
	}*/
/*	
	@Test
	public void testAddAddress(){
		
		//we need to add an user

		user=new User();
		user.setFirstName("arun");
		user.setLastName("dora");
		user.setEmail("arun@gmail.com");
		user.setContactNo("9247242947");
		user.setRole("USER");
		user.setPassword("dillip1994");
		
		assertEquals("Failed To ADD User!", true, userDAO.addUser(user));
		
		//add an address
		
		address = new Address();
		address.setAddressLineOne("AT-NILACHAKRANAGAR,PO-GOPINATH PUR");
		address.setAddressLineTwo("PURI-2,PURI");
		address.setCity("puri");
		address.setState("orissa");
		address.setCountry("india");
		address.setPostalCode("752002");
		address.setBilling(true);
		
		
		//attach the user to address
		
		address.setUser(user);
		
		assertEquals("Failed To add address", true, userDAO.addAddress(address));
		
		//add shipping address
		address = new Address();
		address.setAddressLineOne("AT-ATHARNALA");
		address.setAddressLineTwo("PURI-2,PURI");
		address.setCity("CTC");
		address.setState("orissa");
		address.setCountry("india");
		address.setPostalCode("752006");
		//set shipping to be true
		address.setShipping(true);
		
		//attach the user to address
      address.setUser(user);
		
		assertEquals("Failed To add shipping address", true, userDAO.addAddress(address));
		
		
		
	}
	*/
	
/*	@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("arun@gmail.com");
		//add shipping address
				address = new Address();
				address.setAddressLineOne("AT-baripada");
				address.setAddressLineTwo("mayurbhanj");
				address.setCity("bbsr");
				address.setState("orissa");
				address.setCountry("india");
				address.setPostalCode("767676");
				//set shipping to be true
				address.setShipping(true);
				
				//attach the user to address
		      address.setUser(user);
				
				assertEquals("Failed To add shipping address", true, userDAO.addAddress(address));
				
	}*/
	
	
	@Test
	public void testGetAddress(){
		
		user = userDAO.getByEmail("arun@gmail.com");
		
				
				assertEquals("Failed To retrive the address and size doesnot match",2,
						userDAO.listShippingAddress(user).size());
				
				assertEquals("Failed To retrive the billing address and size doesnot match","puri",
						userDAO.getByBillingAddress(user).getCity());
				
	}
	
}
