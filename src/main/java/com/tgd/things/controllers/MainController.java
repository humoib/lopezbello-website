package com.tgd.things.controllers;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.config.ThingsAppProperties;
import com.tgd.things.service.BoxService;
import com.tgd.things.service.ThingService;
import com.tgd.things.utils.ThingUtils;
import com.tgd.things.utils.WebRequestUtils;

@Controller
@ComponentScan
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	private static final String PATH = "/error";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	BoxService boxService;

	@Autowired
	ThingService thingService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String index(Model model) {
		LOGGER.trace("## HOME ");

		model.addAttribute("context", WebRequestUtils.getContext());

		return "home";
	}

	@RequestMapping(value = { "/main", "/index" }, method = RequestMethod.GET)
	public String main(Model model) {
		LOGGER.trace("## INDEX ");

		model.addAttribute("context", WebRequestUtils.getContext());

		// Boxes
		Iterable<Box> boxes_db = boxService.getAllBoxes();
		model.addAttribute("boxes", boxes_db.iterator());

		HashMap<String, List<ThingPojo>> thingBoxes = new HashMap<String, List<ThingPojo>>();
		for (Box box : boxes_db) {
			List<Thing> things_db = thingService.getBoxThings(box.getId());
			List<ThingPojo> thingPojo_list = new ArrayList();
			for (Thing thingDb : things_db) {
				thingPojo_list.add(ThingUtils.db2pojoThing(thingDb));
			}
			thingBoxes.put(String.valueOf(box.getId()), thingPojo_list);
		}
		model.addAttribute("thingBoxes", thingBoxes);

		// Things
		List<Thing> things_db = thingService.getFirstTwentyThings();
		List<ThingPojo> things = new ArrayList();
		for (Thing thingDb : things_db) {
			things.add(ThingUtils.db2pojoThing(thingDb));
		}
		model.addAttribute("things", things);

		return "index";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signup(Model model) {
		LOGGER.trace("## SIGN-UP ");

		model.addAttribute("context", WebRequestUtils.getContext());

		return "signup";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/systeminfo", method = RequestMethod.GET)
	public String systeminfo(Model model, HttpServletRequest request) {
		LOGGER.trace("## SYSTEM INFO");

		ThingsAppProperties config = applicationContext.getBean(ThingsAppProperties.class);
		model.addAttribute("baseUrl", config.getBaseUrl());

		// model.addAttribute("thread_count",
		// ManagementFactory.getThreadMXBean().getThreadCount());

		// Memory
		model.addAttribute("free_memory", Runtime.getRuntime().freeMemory() / 1024 / 1024); // MB
		model.addAttribute("total_memory", Runtime.getRuntime().totalMemory() / 1024 / 1024); // MB
		model.addAttribute("max_memory", Runtime.getRuntime().maxMemory() / 1024 / 1024); // MB

		model.addAttribute("available_processors", Runtime.getRuntime().availableProcessors());

		return "systeminfo";
	}

	@RequestMapping(value = { "/login2" }, method = RequestMethod.GET)
	public String login(Model model) {
		LOGGER.trace("## LOGIN ");

		model.addAttribute("context", WebRequestUtils.getContext());

		return "login";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model, HttpServletRequest request) {
		LOGGER.trace("## HELO ");

		ThingsAppProperties config = applicationContext.getBean(ThingsAppProperties.class);
		config.printVariable();

		// ThingsAppProperties config = new ThingsAppProperties();

		LOGGER.debug("ConfigurationProperties.getBaseUrl(): {}", config.getBaseUrl());
		LOGGER.debug("ConfigurationProperties.getValor(): {}", config.getValor());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			model.addAttribute("username", authentication.getName());
		}

		model.addAttribute("baseUrl", config.getBaseUrl());
		model.addAttribute("valor", config.getValor());

		return "hello";
	}

	/*
	 * @RequestMapping(value = PATH) public String handleError(HttpServletRequest
	 * request) { Integer statusCode = (Integer)
	 * request.getAttribute("javax.servlet.error.status_code"); Exception exception
	 * = (Exception) request.getAttribute("javax.servlet.error.exception");
	 * 
	 * return String.format(
	 * "<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
	 * "<div>Exception Message: <b>%s</b></div><body></html>", statusCode, exception
	 * == null ? "N/A" : exception.getMessage());
	 * 
	 * // return "Error handling"; }
	 */
}