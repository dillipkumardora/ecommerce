package com.niit.shopperBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shopperBackend.dao.CategoryDAO;
import com.niit.shopperBackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	static {
		Category category=new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is category dude");
		category.setImageURL("1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(1);
		category.setName("Mobile Accessories");
		category.setDescription("This is nice dude");
		category.setImageURL("2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(1);
		category.setName("Electronic Instrument");
		category.setDescription("This is vert nice dude");
		category.setImageURL("3.png");
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
