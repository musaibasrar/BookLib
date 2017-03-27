package com.bookan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	
	 @RequestMapping("/hello")  
	    public ModelAndView helloWorld() {  
	       System.out.println("Inside hello world");
	        return new ModelAndView("addbook");  
	    }  
}
