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
public final class FieldsManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(FieldsManager.class);

	// @Autowired
	protected ThingService thingService;

	// @Autowired
	// @Qualifier("customFieldsService")
	protected CustomFieldsService customFieldsService;

	public FieldsManager(ThingService thingService, CustomFieldsService customFieldsService) {

		this.thingService = thingService;
		this.customFieldsService = customFieldsService;

		LOGGER.trace("FieldsManager constructor");
		LOGGER.trace("this.thingService -> {}", thingService);
		LOGGER.trace("this.customFieldsService -> {}", customFieldsService);
	}

	/**
	 * 
	 * @param thingType
	 * @return
	 */
	public static Map getViewFields(ThingType thingType) {
		// Get all thing fields
		// fieldsService

		return null;
	}

	String getViewHtmlField(Thing thing) {
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param myThing
	 * @param thingTypeid
	 * @return
	 */
	public Thing updateFieldValues(HttpServletRequest request, Thing myThing, ThingPojo myThingPojo,
			String thingTypeid) {

		// CUSTOM FIELDS
		// TODO : suponemos que todos los camps están en la pantalla
		List<CustomFieldReduced> fields = customFieldsService
				.getAllFieldsFromThingType(thingService.findThingTypeById(myThing.getThingType().getId()));
		for (CustomFieldReduced field : fields) {
			LOGGER.debug("FIELD ---> id: {} name: {} type: {}", field.getKey(), field.getName(), field.getType());
			String temp = request.getParameter("cf_" + field.getId());
			LOGGER.debug("REQUEST PARAM {} value {}", "cf_" + field.getId(),
					request.getParameter("cf_" + field.getId()));
			if (temp != "") {
				int ret = customFieldsService.updateValue(myThing, field.getName(), temp);
				LOGGER.debug("updated " + temp + " - ret:" + ret);
			}
		}
		return myThing;
	}

	/**
	 * 
	 * @param request
	 * @param myThing
	 * @param thingTypeId
	 * @return
	 */
	public Thing updateFieldValues(Map<String, Object> values, Thing myThing, ThingPojo myThingPojo,
			String thingTypeId) {

		// CUSTOM FIELDS
		// TODO : suponemos que todos los camps están en la pantalla

		LOGGER.debug("customFieldsService: " + customFieldsService);

		List<CustomFieldReduced> fields = customFieldsService
				.getAllFieldsFromThingType(this.thingService.findThingTypeById(myThing.getThingType().getId()));
		for (CustomFieldReduced field : fields) {
			LOGGER.debug("FIELD ---> id: {} name: {} type: {}", field.getKey(), field.getName(), field.getType());
			String temp = (String) values.get(field.getName()); // ("cf_" +
																// field.getId());
			LOGGER.debug("REQUEST PARAM {} value {}", "cf_" + field.getId(), (String) values.get(field.getName()));
			if (temp != "") {
				int ret = customFieldsService.updateValue(myThing, field.getName(), temp);
				LOGGER.debug("updated " + temp + " - ret:" + ret);
			}
		}
		return myThing;
	}

}
