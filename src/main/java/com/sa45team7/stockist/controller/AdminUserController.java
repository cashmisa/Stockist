package com.sa45team7.stockist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.service.UserService;

import com.sa45team7.stockist.validator.UserValidator;
import com.sa45team7.stockist.exception.UserNotFound;
import com.sa45team7.stockist.model.User;

@RequestMapping("/admin/user")
@Controller
public class AdminUserController {
	// CRUD users
	// XIN YING

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@RequestMapping(value = { "", "/listuser" }, method = RequestMethod.GET) // admin/user/listuser
	public ModelAndView listUser() {
		ModelAndView modelAndView = new ModelAndView("list-user");
		List<User> userList = userService.findAllUsers();
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewUser() {
		ModelAndView modelAndView = new ModelAndView("new-user", "user", new User()); // viewname, modelname,
																						// modelobject
		ArrayList<String> roleList = userService.findAllRoles();
		modelAndView.addObject("roleList", roleList);
		return modelAndView;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST) // admin/user/create
	public ModelAndView createdUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("new-user");
			ArrayList<String> roleList = userService.findAllRoles();
			modelAndView.addObject("roleList", roleList);
			return modelAndView;
		}

		userService.createUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/user/listuser");
		String message = "New User <strong>" + user.getUserName() + "</strong> was successfully added.";

		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/edituser/{userName}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable String userName) throws UserNotFound {
		ModelAndView modelAndView = new ModelAndView("edit-user");
		User user = userService.findUser(userName);
		modelAndView.addObject("user", user);
		ArrayList<String> roleList = userService.findAllRoles();
		modelAndView.addObject("roleList", roleList);
		return modelAndView;
	}

	@RequestMapping(value = "/edituser/{userName}", method = RequestMethod.POST) // admin/edituser/whicheveruser
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String userName,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("edit-user");
			ArrayList<String> roleList = userService.findAllRoles();
			modelAndView.addObject("roleList", roleList);
			return modelAndView;
		}

		userService.changeUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/user/listuser");
		String message = "User <strong>" + user.getUserName() + "</strong> was successfully updated.";

		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "deleteuser/{userName}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String userName, final RedirectAttributes redirectAttributes)
			throws UserNotFound {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/user/listuser");
		User user = userService.findUser(userName);
		userService.removeUser(user);
		String message = "User <strong>" + user.getUserName() + "</strong> was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/edituser/reset/{userName}", method = RequestMethod.GET)
	public ModelAndView resetUser(@PathVariable String userName, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/user/listuser");
		User user = userService.findUser(userName);
		userService.resetUser(user);
		String message = "User <strong>" + user.getUserName() + "</strong>'s password was successfully reset.";

		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}
}
