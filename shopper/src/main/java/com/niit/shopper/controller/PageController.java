package com.niit.shopper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopper.exception.ProductNotFoundException;
import com.niit.shopperBackend.dao.CategoryDAO;
import com.niit.shopperBackend.dao.ProductDAO;
import com.niit.shopperBackend.dto.Category;
import com.niit.shopperBackend.dto.Product;


@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value={"/" ,"/home" ,"/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside Page controller index method - INFO");
		logger.debug("Inside Page controller index method - DEBUG");

		
		
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
		
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);

		return mv;
		
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);

		return mv;
		
	}
	
	@RequestMapping(value={"/viewproducts"})
	public ModelAndView viewproducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","My Product");
		mv.addObject("userClickViewproduct",true);

		return mv;
		
	}
	
	/*
	 * to load all products based on category
	 * */
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
		
	}
	
	

	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
		
	}
	
	/*viewing single product
	 * 
	 * */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product ==null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		//update the view
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product" ,product);
		mv.addObject("userClickShowProduct" ,true);
		
		
		return mv;
	}
	
	@RequestMapping(value={"/register"})
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Register");
		return mv;
		
	}
	//login
	
	
	@RequestMapping(value={"/login"})
	public ModelAndView login(@RequestParam(name="error" , required =false) String error,
			                  @RequestParam(name="logout" , required =false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		
		if(error!=null){
			mv.addObject("message" , "Invalid User Name And password ");	
		}
		
		if(logout!=null){
			mv.addObject("message" , "Logout SuccessFully ");	
		}
		mv.addObject("title","Login");
		return mv;
		
	}
	//access denied page
	@RequestMapping(value={"/access-denied"})
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title","403-Access Denied");
		mv.addObject("errorTitle","ohhh No whats Wrong !!!!");
		mv.addObject("errorDescription","You are not authorized to visit the page");
		return mv;
		
	}
	
	/*logout*/
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		//first fetch authentication
		
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		
		if(au!=null){
			
			new SecurityContextLogoutHandler().logout(request, response, au);
		}
		
		
		
		return "redirect:/login?logout";
	}
	
}
