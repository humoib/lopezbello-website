package com.tgd.things.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgd.things.beans.db.security.User;
import com.tgd.things.config.ThingsAppProperties;
import com.tgd.things.service.BoxService;
import com.tgd.things.service.CustomFieldsService;
import com.tgd.things.service.LabelService;
import com.tgd.things.service.ThingService;
import com.tgd.things.service.security.UserService;
import com.tgd.things.utils.WebRequestUtils;

@Controller
@ComponentScan
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserService userService;

	@Autowired
	LabelService labelService;

	@Autowired
	BoxService boxService;

	@Autowired
	ThingService thingService;

	@Autowired
	CustomFieldsService customFieldsService;

	@RequestMapping(value = { "/admin/", "/admin/index" }, method = RequestMethod.GET)
	public String adminIndex(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN INDEX ");

		model.addAttribute("context", ThingsAppProperties.getContext());

		return "admin/index";
	}

	@RequestMapping(value = { "/admin/users" }, method = RequestMethod.GET)
	public String adminUsers(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USERS");

		model.addAttribute("context", ThingsAppProperties.getContext());

		model.addAttribute("users", userService.getAllUsers());

		return "admin/users";
	}

	@RequestMapping(value = { "/admin/groups" }, method = RequestMethod.GET)
	public String adminGroups(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN GROUPS");

		model.addAttribute("context", ThingsAppProperties.getContext());

		model.addAttribute("boxes", boxService.getAllBoxes());

		return "admin/groups";
	}

	@RequestMapping(value = { "/admin/boxes" }, method = RequestMethod.GET)
	public String adminPlaces(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN BOXES");

		model.addAttribute("context", ThingsAppProperties.getContext());

		model.addAttribute("boxes", boxService.getAllBoxes());

		return "admin/boxes";
	}

	@RequestMapping(value = { "/admin/thingtypes" }, method = RequestMethod.GET)
	public String adminThingTypes(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN THING-TYPES");

		model.addAttribute("context", ThingsAppProperties.getContext());
		model.addAttribute("adminpage", "Thing Types");

		model.addAttribute("thingtypes", thingService.getAllThingTypes());

		return "admin/thingtypes";
	}

	@RequestMapping(value = { "/admin/customfields" }, method = RequestMethod.GET)
	public String adminCustomFields(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN CUSTOM-FIELD");

		model.addAttribute("context", ThingsAppProperties.getContext());

		model.addAttribute("customfields", customFieldsService.getAllFields());

		return "admin/customfields";
	}

	//
	// LABELS
	//

	@RequestMapping(value = { "/admin/labels" }, method = RequestMethod.GET)
	public String adminLabels(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN LABELS ");

		model.addAttribute("context", ThingsAppProperties.getContext());

		model.addAttribute("labels", labelService.getLabels());

		return "admin/labels";
	}

	@RequestMapping(value = { "/admin/systemInfo" }, method = RequestMethod.GET)
	public String systemInfo(Model model, HttpServletRequest request) {
		LOGGER.trace("## SYSTEM INFO");

		model.addAttribute("context", ThingsAppProperties.getContext());

		return "admin/systemInfo";
	}

	//
	// USERS
	//

	@RequestMapping(value = { "/admin/user/add" }, method = RequestMethod.GET)
	public String addUser(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USER");

		model.addAttribute("context", ThingsAppProperties.getContext());

		return "admin/user-form";
	}

	@RequestMapping(value = { "/admin/user/add" }, method = RequestMethod.POST)
	public String addUserPost(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USER");

		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		userService.addUser(username, fullname, email, password);

		model.addAttribute("context", ThingsAppProperties.getContext());
		model.addAttribute("users", userService.getAllUsers());

		return "redirect:" + ThingsAppProperties.getContext() + "/admin/users";
	}

	@RequestMapping(value = { "/admin/user/edit" }, method = RequestMethod.GET)
	public String editUser(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USER - EDIT 1");

		model.addAttribute("context", ThingsAppProperties.getContext());

		LOGGER.debug("userId: {}", request.getParameter("userId"));
		User user = userService.findById(Long.parseLong(request.getParameter("userId")));
		model.addAttribute("user", user);

		return "admin/user-form";
	}

	@RequestMapping(value = { "/admin/user/edit" }, method = RequestMethod.POST)
	public String editUserPost(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USER - EDIT 2");

		model.addAttribute("context", ThingsAppProperties.getContext());

		LOGGER.debug("userId: {}", request.getParameter("userId"));
		User user = userService.findById(Long.parseLong(request.getParameter("userId")));

		LOGGER.debug("user retrieved: {}", user);

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user.setFullname(fullname);
		user.setEmail(email);
		user.setPassword(password);

		userService.save(user);

		model.addAttribute("context", ThingsAppProperties.getContext());
		model.addAttribute("users", userService.getAllUsers());

		return "redirect:" + ThingsAppProperties.getContext() + "/admin/users";
	}

}