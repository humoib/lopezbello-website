package com.tgd.things.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgd.things.config.ThingsAppProperties;
import com.tgd.things.service.ThingService;
import com.tgd.things.utils.WebRequestUtils;

@Controller
@ComponentScan
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	private static final String PATH = "/error";

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	ThingService thingService;

	@RequestMapping(value = { "/login2" }, method = RequestMethod.GET)
	public String login(Model model) {
		LOGGER.trace("## LOGIN ");

		model.addAttribute("context", WebRequestUtils.getContext());

		return "login";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		LOGGER.trace("## INDEX ");

		model.addAttribute("context", WebRequestUtils.getContext());
		model.addAttribute("things", thingService.getFirstTwentyThings());

		return "index";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model, HttpServletRequest request) {
		LOGGER.trace("## HELO ");


		ThingsAppProperties config = applicationContext.getBean(ThingsAppProperties.class);
		config.printVariable();
		
		//ThingsAppProperties config = new ThingsAppProperties();

		LOGGER.debug("ConfigurationProperties.getBaseUrl(): {}", config.getBaseUrl());
		LOGGER.debug("ConfigurationProperties.getValor(): {}", config.getValor());
		
		model.addAttribute("baseUrl", config.getBaseUrl());
		model.addAttribute("valor", config.getValor());

		return "hello";
	}

	/*
	 * @RequestMapping(value = PATH) public String
	 * handleError(HttpServletRequest request) { Integer statusCode = (Integer)
	 * request.getAttribute("javax.servlet.error.status_code"); Exception
	 * exception = (Exception)
	 * request.getAttribute("javax.servlet.error.exception");
	 * 
	 * return String.format(
	 * "<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
	 * "<div>Exception Message: <b>%s</b></div><body></html>", statusCode,
	 * exception == null ? "N/A" : exception.getMessage());
	 * 
	 * // return "Error handling"; }
	 */
}