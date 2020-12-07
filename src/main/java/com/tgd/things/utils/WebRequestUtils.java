package com.tgd.things.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tgd.things.controllers.MainController;

public class WebRequestUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebRequestUtils.class);

	public static String getContext() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			LOGGER.debug("Request Context: {}", request.getContextPath());
			return request.getContextPath();
		} else {
			// fallback logic if request won't work...
		}
		return null;
	}

}
