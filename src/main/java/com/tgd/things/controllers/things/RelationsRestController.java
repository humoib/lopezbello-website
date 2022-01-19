package com.tgd.things.controllers.things;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.tgd.things.beans.RelationPayload;
import com.tgd.things.service.ThingService;

@RestController
public class RelationsRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelationsRestController.class);

	@Autowired
	ThingService thingService;

	static final String REST_VERSION = "rest/api/1";

	@PutMapping(REST_VERSION + "/thing/relate")
	public ResponseEntity<?> relateThings(HttpServletRequest request, @RequestBody String payload) {
		LOGGER.debug("## relateThings");

		LOGGER.debug("payload: {}", payload);

		RelationPayload relation = new Gson().fromJson(payload, RelationPayload.class);

		// LOGGER.debug("## relateThings -> source {} target: {}", source,
		// target);

		int retCode = thingService.relateThings(relation.getSource(), relation.getTarget());
		if (retCode == 0) {
			LOGGER.debug("## relateThings OK");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// return ResponseEntity.ok().build(); // return new
			// Thing(counter.incrementAndGet(),
		} else {
			LOGGER.debug("## relateThings KO retCode: {}", retCode);
			return null;
		}
	}
}
