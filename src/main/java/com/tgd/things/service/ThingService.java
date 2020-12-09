package com.tgd.things.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.ThingPojo2;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.repository.BoxRepository;
import com.tgd.things.repository.ThingRelationRepository;
import com.tgd.things.repository.ThingRepository;
import com.tgd.things.repository.ThingTypeRepository;

@Service
@Transactional
public class ThingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingService.class);

	@Autowired
	protected BoxRepository boxRepository;

	@Autowired
	protected ThingRepository thingRepository;

	@Autowired
	protected ThingTypeRepository thingTypeRepository;

	@Autowired
	protected ThingRelationRepository thingRelationRepository;

	public String getReadableKey(Thing thing) {
		Optional<Thing> mything = thingRepository.findById(thing.getId());
		Optional<Box> mybox = boxRepository.findById(thing.getBox().getId());
		return mybox.get().getKey() + "-" + mything.get().getKey();
	}

	// TODO: Se debe reducir a un objeto más ligero (ThingReduced)
	public Iterable<Thing> getAllThings() {
		return thingRepository.findAll();
	}

	public Optional<Thing> getThing(Long id) {
		return thingRepository.findById(id);
	}

	public List<Thing> getFirstTwentyThings() {
		return thingRepository.getFirstTwentyThings();
	}

	public List<Thing> searchThings(String text) {
		return thingRepository.findBySummaryContainingIgnoreCase(text);
	}

	public List<Thing> getBoxThings(Long id) {
		return thingRepository.getBoxThings(id);
	}

	public ThingType findThingTypeById(Long id) {
		return thingTypeRepository.findById(id).get();
	}

	/**
	 * 
	 * @param thingPojo
	 * @return
	 */
	@Transactional
	public Thing saveThing(ThingPojo thingPojo) {
		LOGGER.debug("## saveThing");

		Thing thing = new Thing();
		thing.setId(thingPojo.getId());
		thing.setBox(boxRepository.findById((long) thingPojo.getBoxId()).get());

		Integer lastKey = boxRepository.getLastKey(thingPojo.getBoxId());
		if (lastKey == null) {
			lastKey = 1;
		} else {
			lastKey++;
		}
		boxRepository.updateLastKey(lastKey, thingPojo.getBoxId());
		thing.setKey(lastKey);
		if (thingPojo.getSummary().trim().length() > 0) {
			thing.setSummary(thingPojo.getSummary());
		} else {
			thing.setSummary("--BLANK--");
		}
		if (thingPojo.getCreated() != null) {
			thing.setCreated(thingPojo.getCreated());
		} else {
			thing.setCreated(new Date());
		}
		thing.setUpdated(new Date());
		thing.setThingType(findThingTypeById(thingPojo.getThingTypeId()));

		LOGGER.debug("## saveThing: {}", thing);

		// TODO: other fields
		//
		return thingRepository.save(thing);
	}

	// Thing Types
	public Iterable<ThingType> getAllThingTypes() {
		return thingTypeRepository.findAll();
	}

	public Iterable<ThingPojo> getAllRelatedThings(Thing thing) {
		LOGGER.debug("1111 thing: " + thing.getId());

		List<ThingPojo2> related = thingRepository.findRelatedById(thing.getId());
		List<ThingPojo> related2send = new ArrayList();

		for (ThingPojo2 thingPojo : related) {
			LOGGER.debug("------- " + thingPojo.getId() + " " + thingPojo.getSummary());
			ThingPojo tmp = new ThingPojo();
			tmp.setId(Long.parseLong(thingPojo.getId()));
			tmp.setSummary(thingPojo.getSummary());
			tmp.setHumanKey(getReadableKey(getThing(Long.parseLong(thingPojo.getId())).get()));
			related2send.add(tmp);
		}
		return related2send;
	}

	public int relateThings(String source, String target) {
		// thingTypeRepository.findAllById(arg0)

		List relations = thingRelationRepository.findBySourceAndTargetIds(Long.parseLong(source),
				Long.parseLong(target));

		LOGGER.debug(relations.toString());
		if (relations.size() > 0) {
			LOGGER.warn("EXISTS!");
		} else {
			thingRelationRepository.insertRelation(Long.parseLong(source), Long.parseLong(target));
			return 0;
		}
		return -1;
	}

}
