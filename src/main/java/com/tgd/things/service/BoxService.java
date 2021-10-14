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

import com.tgd.things.beans.BoxPojo;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.repository.BoxRepository;
import com.tgd.things.repository.ThingTypeRepository;
import com.tgd.things.repository.ThingTypeSchemaRepository;

@Service
@Transactional
public class BoxService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoxService.class);

	@Autowired
	protected BoxRepository boxRepository;

	@Autowired
	protected ThingTypeRepository thingTypeRepository;

	@Autowired
	protected ThingTypeSchemaRepository thingTypeSchemaRepository;

	public Iterable<Box> getAllBoxes() {
		return boxRepository.findAll();
	}

	public Optional<Box> getById(Long boxId) {
		return boxRepository.findById(boxId);
	}

	public Optional<Box> getByBoxKey(String boxKey) {
		return boxRepository.findByBoxKey(boxKey);
	}
	
	public Iterable<BoxPojo> getAllBoxesWithThingTypes() {
		Iterable<Box> boxes = boxRepository.findAll();

		List<BoxPojo> boxesPojo = new ArrayList();
		for (Box box : boxes) {
			BoxPojo myBox = new BoxPojo(box.getId());
			myBox.setName(box.getName());
			myBox.setThingTypeSchema(box.getThingTypeSchema().getId());
			myBox.setThingTypes(thingTypeRepository.findAllByBoxId(box.getId()));
			boxesPojo.add(myBox);
		}
		return boxesPojo;
	}

	public Long getLastKey(Long boxId) {
		return boxRepository.getLastKey(boxId);
	}

	@Transactional
	public Box saveBox(BoxPojo boxPojo) {
		LOGGER.debug("## saveBox");

		Box box = new Box();
		box.setId(boxPojo.getId());
		box.setName(boxPojo.getName());
		box.setCreated(boxPojo.getCreated());

		LOGGER.debug("## saveBox: {}", box);

		return boxRepository.save(box);
	}


}
