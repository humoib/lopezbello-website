package com.tgd.things.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

		model.addAttribute("context", WebRequestUtils.getContext());

		return "admin/index";
	}

	@RequestMapping(value = { "/admin/users" }, method = RequestMethod.GET)
	public String adminUsers(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN USERS");

		model.addAttribute("context", WebRequestUtils.getContext());

		model.addAttribute("users", userService.getAllUsers());

		return "admin/users";
	}

	@RequestMapping(value = { "/admin/groups" }, method = RequestMethod.GET)
	public String adminGroups(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN GROUPS");

		model.addAttribute("context", WebRequestUtils.getContext());

		model.addAttribute("boxes", boxService.getAllBoxes());

		return "admin/groups";
	}

	@RequestMapping(value = { "/admin/boxes" }, method = RequestMethod.GET)
	public String adminPlaces(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN BOXES");

		model.addAttribute("context", WebRequestUtils.getContext());

		model.addAttribute("boxes", boxService.getAllBoxes());

		return "admin/boxes";
	}

	@RequestMapping(value = { "/admin/thingtypes" }, method = RequestMethod.GET)
	public String adminThingTypes(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN THING-TYPES");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("adminpage", "Thing Types");

		model.addAttribute("thingtypes", thingService.getAllThingTypes());

		return "admin/thingtypes";
	}

	@RequestMapping(value = { "/admin/customfields" }, method = RequestMethod.GET)
	public String adminCustomFields(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN CUSTOM-FIELD");

		model.addAttribute("context", WebRequestUtils.getContext());

		model.addAttribute("customfields", customFieldsService.getAllFields());

		return "admin/customfields";
	}

	//
	// LABELS
	//

	@RequestMapping(value = { "/admin/labels" }, method = RequestMethod.GET)
	public String adminLabels(Model model, HttpServletRequest request) {
		LOGGER.trace("## ADMIN LABELS ");

		model.addAttribute("context", WebRequestUtils.getContext());

		model.addAttribute("labels", labelService.getLabels());

		return "admin/labels";
	}

	@RequestMapping(value = { "/admin/systemInfo" }, method = RequestMethod.GET)
	public String systemInfo(Model model, HttpServletRequest request) {
		LOGGER.trace("## SYSTEM INFO");

		model.addAttribute("context", WebRequestUtils.getContext());

		return "admin/systemInfo";
	}

}