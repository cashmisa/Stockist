package com.sa45team7.stockist.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sa45team7.stockist.model.User;
import com.sa45team7.stockist.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			logger.info("Username: " + authentication.getName());
			for (GrantedAuthority element : authentication.getAuthorities()) {
				logger.info("Role: " + element.getAuthority());
			}
		}

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/change-pass", method = RequestMethod.GET)
	public String changePassword() {
		return "change-pass";
	}

	@RequestMapping(value = "/change-pass", method = RequestMethod.POST)
	public ModelAndView requestChangePassword(HttpServletRequest request, final RedirectAttributes redirectAttributes)
			throws ServletException, IOException {
		String oldPassword = request.getParameter("old-password");
		String newPassword = request.getParameter("new-password");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();

		User user = userService.authenticate(userName, oldPassword);

		ModelAndView modelAndView = new ModelAndView("redirect:/change-pass");
		if (user == null) {
			String message = "Wrong password.";
			redirectAttributes.addFlashAttribute("error", message);
			return modelAndView;
		}
		user.setPassword(newPassword);
		userService.updatePassword(user);
		String message = "Updated password.";
		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}
}
