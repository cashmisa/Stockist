package com.sa45team7.stockist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.service.UserService;

import com.sa45team7.stockist.model.User;

@RequestMapping("/admin/user")
@Controller
public class AdminUserController {
	//CRUD users
	//XIN YING
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/listuser", method = RequestMethod.GET) //admin/user/listuser
	public ModelAndView listUser() 
	{
		ModelAndView modelAndView = new ModelAndView("list-user");
		List<User> userList = userService.findAllUsers();
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST) //admin/user/create
	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) 
	{
		String createdUser = "Created user: " + user.getUsername();

		userService.createUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/user/listuser");

		redirectAttributes.addFlashAttribute("createdUser", createdUser);
		return modelAndView;
	}
	
	@RequestMapping(value = "/edituser/{userName}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable String userName) 
	{
		ModelAndView modelAndView = new ModelAndView("edit-user");
		User user = userService.findUser(userName);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/edituser/{userName}", method = RequestMethod.POST) //admin/edituser/whicheveruser
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String userName,
			final RedirectAttributes redirectAttributes)
	{
		String updatedUser = "Updated user: " + user.getUsername();
		
		userService.changeUser(user);	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/user/listuser");

		redirectAttributes.addFlashAttribute("updatedUser", updatedUser);
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteuser/{userName)", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String userName, final RedirectAttributes redirectAttributes)
	{
		
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/user/list");
		User user = userService.findUser(userName);
		userService.removeUser(user);
		String deletedUser = "Deleted user: " + user.getUsername();	

		redirectAttributes.addFlashAttribute("deletedUser", deletedUser);
		return modelAndView;
	}
}
