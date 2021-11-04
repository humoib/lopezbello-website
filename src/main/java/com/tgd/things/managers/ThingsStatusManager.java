package com.tgd.things.managers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Status;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.repository.ThingTypeSchemaRepository;
import com.tgd.things.service.CustomFieldsService;
import com.tgd.things.service.ThingService;

@Component
// @Service("FieldsManager")
// @Configurable
public final class ThingsStatusManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsStatusManager.class);

	@Autowired
	protected static ThingService thingService;

	@Autowired
	protected static ThingTypeSchemaRepository thingTypeSchemaRepository;

	public ThingsStatusManager(ThingService thingService, CustomFieldsService customFieldsService) {

		this.thingService = thingService;

		LOGGER.trace("FieldsManager constructor");
		LOGGER.trace("this.thingService -> {}", thingService);
		LOGGER.trace("this.customFieldsService -> {}", customFieldsService);
	}

	public static Status getStatus(ThingPojo editThing) {

		// get from db
		Thing thingDb = thingService.getThing(editThing.getId()).get();
		if (thingDb.getStatus() == null) {
			Status status = new Status();
			
			
			return null;
		} else {
			
		}
		return null;
	}

}
