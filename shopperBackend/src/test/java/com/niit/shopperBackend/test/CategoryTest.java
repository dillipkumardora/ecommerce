package com.niit.shopperBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shopperBackend.dao.CategoryDAO;
import com.niit.shopperBackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopperBackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * 
	 * category.setName("Mobile");
	 * category.setDescription("Thease are all regarding to mobiles");
	 * category.setImageURL("2.png");
	 * 
	 * assertEquals("category is added Successfully",true,categoryDAO.add(
	 * category)); }
	 */
	/*
	 * @Test public void testGetCategory(){
	 * 
	 * category = categoryDAO.get(5);
	 * assertEquals("category is retreved Successfully","box",category.getName()
	 * );
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory(){
	 * 
	 * category = categoryDAO.get(2);
	 * category.setName("electronic_accessories");
	 * category.setImageURL("3.jpg");
	 * assertEquals("category is updateded Successfully",true,categoryDAO.update
	 * (category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory(){
	 * 
	 * category = categoryDAO.get(4);
	 * 
	 * assertEquals("category is deleteed Successfully",true,categoryDAO.delete(
	 * category));
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testListCategory(){
	 * 
	 * category = categoryDAO.get(4);
	 * 
	 * assertEquals("Fetch data successsfully from database",4,categoryDAO.list(
	 * ).size());
	 * 
	 * }
	 */
	@Test
	public void testCrudCategory() {

		//feteching data
		category = new Category();

		category.setName("Mobile");
		category.setDescription("Thease are all regarding to mobiles");
		category.setImageURL("1.png");

		assertEquals("category is added Successfully", true, categoryDAO.add(category));

		category = new Category();

		category.setName("mobile_accessories");
		category.setDescription("Thease are all regarding to mobiles accessories");
		category.setImageURL("5.png");

		assertEquals("category is added Successfully", true, categoryDAO.add(category));
		//updating data
		category = categoryDAO.get(2);
		  category.setName("electronic_accessories");
		  category.setImageURL("3.jpg");
		  assertEquals("category is updateded Successfully",true,categoryDAO.update(category));
		  
		  //delete operation
			  assertEquals("category is deleteed Successfully",true,categoryDAO.delete(category));
			//
			  assertEquals("Fetch data successsfully from database",4,categoryDAO.list().size());
						 

	}

}
