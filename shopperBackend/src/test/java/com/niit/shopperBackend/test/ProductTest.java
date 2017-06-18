package com.niit.shopperBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopperBackend.dao.ProductDAO;
import com.niit.shopperBackend.dto.Product;

public class ProductTest {

	

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;

	private static Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopperBackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}
	/*
	@Test
	public void testCRUDProduct(){
		
		product = new Product();
		
		product.setName("samsung s5");
		product.setBrand("samsung");
		product.setDescription("It is awesome mobile");
		product.setUnitPrice(10000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		
		assertEquals("Something gonna wrong while inserting product",
				true,productDAO.add(product));
		
		
		product = productDAO.get(2);
		product.setName("one plus");
		assertEquals("Something gonna wrong while updating product",
				true,productDAO.update(product));
		
		assertEquals("Something gonna wrong while deleting the existing product",
				true,productDAO.delete(product));
		//list
		assertEquals("Something gonna wrong while fetching product",
				4,productDAO.list().size());
		
	}*/
	
	
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Something gonna wrong while fetching product",
				3,productDAO.listActiveProducts().size());
		
	}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something gonna wrong while fetching product",
				1,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something gonna wrong while fetching product",
				1,productDAO.listActiveProductsByCategory(2).size());
		
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("Something gonna wrong while fetching product",
				1,productDAO.getLatestActiveProducts(2).size());
		
	}
}

