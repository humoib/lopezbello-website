package com.tgd.things.managers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.CustomFieldReduced;
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.service.CustomFieldsService;
import com.tgd.things.service.ThingService;

@Component
// @Service("FieldsManager")
// @Configurable
public final class ThingsManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsManager.class);

	// @Autowired
	protected ThingService thingService;

	
	public ThingsManager(ThingService thingService, CustomFieldsService customFieldsService) {

		this.thingService = thingService;
	
		LOGGER.trace("FieldsManager constructor");
		LOGGER.trace("this.thingService -> {}", thingService);
		LOGGER.trace("this.customFieldsService -> {}", customFieldsService);
	}

	

}
