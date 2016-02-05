package com.webpage.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webpage.model.User;
import com.webpage.persistence.impl.UserImpl;
import com.webpage.persistence.util.UserInterface;

@Controller
@RequestMapping("/")
public class MainController {
	
	private static UserInterface userInterface;
	
	static{
		userInterface = new UserImpl();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView mainPage(){
		User user = new User();
		return new ModelAndView("page","user_details", user);
	}
	
	@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)
	public @ResponseBody List<User> getAllUsersList(){
		return userInterface.getAllUsers();
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public @ResponseBody User addUserOnSubmit(@RequestBody User user){
		userInterface.addUserDetails(user);
		return user;
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public  @ResponseBody User deleteUserOnSubmit(@RequestBody User user){
		userInterface.removeUserDetails(user);
		return user;
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public @ResponseBody User updateUserOnSubmit(@RequestBody User user){
		userInterface.updateUserDetails(user);
		return user;
	}

}
