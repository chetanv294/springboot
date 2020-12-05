package com.developerstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.developerstack.service.impl.UserService;

@Controller
public class DashboardController {
	
	/*@Autowired
	private UserService userService;*/
	//@Qualifier("userDetailsServiceSecure")
	
	/*@Autowired
	@Qualifier("TEMPuserDetailService")
	UserDetailsService userDetailsService;*/

	@Autowired
	@Qualifier("TEMPuserDetailService")
	private UserService userService;

    @RequestMapping(value = "/dashboard/home", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", userService.getUsers());
    	//model.addObject("users", "static");
    	model.setViewName("dashboard");
    	return model;
    }

}
