package com.niit.shopper.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		
		mv.addObject("errorTitle","The Page Is not Present");
		mv.addObject("errorDescription","The Page is not in your criteria");
		
		mv.addObject("title","404 page not found");


		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		
		mv.addObject("errorTitle","Product Is not Present");
		mv.addObject("errorDescription","The Product is not avaailable in your criteria");
		
		mv.addObject("title","Product not found");


		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		
		
		mv.addObject("errorTitle","Please Contact Your Administrator");
		
		//Only for debugging purpose
		StringWriter sw=new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		
		mv.addObject("title","!!!!!Error!!!!");


		return mv;
	}
	
}
