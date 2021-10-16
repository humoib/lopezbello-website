package com.tgd.things.controllers.things;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.tgd.things.beans.RestResponse;
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.managers.FieldsManager;
import com.tgd.things.service.BoxService;
import com.tgd.things.service.CustomFieldsService;
import com.tgd.things.service.ThingService;
import com.tgd.things.utils.ThingUtils;

@RestController
public class ThingsRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsRestController.class);

	@Autowired
	ThingService thingService;

	@Autowired
	BoxService boxService;

	@Autowired
	CustomFieldsService customFieldsService;

	static final String REST_VERSION = "rest/api/1";

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(path = { REST_VERSION + "/thing", REST_VERSION + "/thing/{id}" })
	public RestResponse getThings(@RequestParam(value = "name", defaultValue = "World") String summary, String id) {
		LOGGER.trace("## REST getThings");
		LOGGER.debug("Id: {}", id);

		if (id != null && id.contains("-")) {
			// puede ser una thing concreta
		} else {
			// se pide por ID?

		}

		List<Object> ret = new ArrayList();
		// ret.add(new ThingPojo((long) 1));

		Iterable<Thing> thingsDb_list = thingService.getAllThings();
		for (Thing thingDb : thingsDb_list) {
			ret.add(ThingUtils.db2pojoThing(thingDb));
		}

		RestResponse restResponse = new RestResponse();
		restResponse.setCount(ret.size());
		restResponse.setResponse(ret);

		return restResponse;
	}

	/**
	 * 
	 * @param summary
	 */
	@PostMapping(path = REST_VERSION + "/thing", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void postThing(HttpServletRequest request, @RequestBody String body) {
		LOGGER.debug("REST postThing");
		LOGGER.trace("request.getServerName(): {}", request.getServerName());
		LOGGER.trace("http Entity: {}", body);

		ThingPojo requestThing = new Gson().fromJson(body, ThingPojo.class);

		Optional<Box> box = null;
		if (requestThing.getBoxKey() != null) {
			box = boxService.getByBoxKey(requestThing.getBoxKey());
			LOGGER.debug("BOX::: " + box);
		} else if (requestThing.getBoxId() != null) {
			box = boxService.getById(requestThing.getBoxId());
		} else {
			LOGGER.error("Unable to create THING without ThingKey or BoxId");
		}
		requestThing.setBoxId(box.get().getId());

		// ThingPojo saveThing = new ThingPojo();
		// saveThing.setBoxId(Integer.parseInt(boxId));
		// saveThing.setThingTypeId(Long.parseLong(thingTypeId));
		// saveThing.setSummary(summary);

		// saveThing = thing;

		Thing saved = thingService.saveThing(requestThing);
		LOGGER.trace("saved: {}", saved);

		// fields

		HashMap hashMap = new Gson().fromJson(body, HashMap.class);
		LOGGER.trace("hashMap: {}", hashMap);

		FieldsManager fieldsManager = new FieldsManager(thingService, customFieldsService);
		Thing myThing = fieldsManager.updateFieldValues(hashMap, saved, requestThing, null);

		/*
		 * List<CustomFieldReduced> fields = customFieldsService
		 * .getAllFieldsFromThingType(thingService.findThingTypeById(saveThing.
		 * getThingTypeId())); Set keys = hashMap.keySet(); for (CustomFieldReduced
		 * field : fields) { if( keys.contains(field.getName()).){
		 * LOGGER.debug("FIELD ---> id: {} name: {} type: {}", field.getKey(),
		 * field.getName(), field.getType()); String temp = request.getParameter("cf_" +
		 * field.getId()); LOGGER.debug("REQUEST PARAM {} value {}", "cf_" +
		 * field.getId(), request.getParameter("cf_" + field.getId())); if (temp != "")
		 * { int ret = customFieldsService.updateValue(myThing, field.getName(), temp);
		 * LOGGER.debug("updated " + temp + " - ret:" + ret); } } }
		 */

		// return new Thing(counter.incrementAndGet(), String.format(template,
		// name));
	}

}