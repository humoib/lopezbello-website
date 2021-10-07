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
import com.tgd.things.beans.NewCommentPojo;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingComment;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.repository.BoxRepository;
import com.tgd.things.repository.ThingCommentRepository;
import com.tgd.things.repository.ThingTypeRepository;
import com.tgd.things.repository.ThingTypeSchemaRepository;

@Service
@Transactional
public class ThingCommentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingCommentService.class);

	@Autowired
	protected ThingService thingService;

	@Autowired
	protected UserService userService;

	@Autowired
	protected ThingCommentRepository thingCommentRepository;

	@Transactional
	public ThingComment saveComment(NewCommentPojo newCommentPojo) {
		LOGGER.debug("## saveComment");
		ThingComment comment = new ThingComment();
		comment.setComment(newCommentPojo.getComment());
		Optional<Thing> thingOptional = thingService.getThing(newCommentPojo.getThingId());
		comment.setThing(thingOptional.get());
		comment.setActor(userService.getFooUser());
		comment.setCreated(new Date());
		LOGGER.debug("## saveComment: {}", comment);
		return thingCommentRepository.save(comment);
	}

	public Iterable<ThingComment> getComments(Thing thing) {
		if (thing != null) {
			return thingCommentRepository.getCommentsFromThing(thing.getId());
		} else
			return null;
	}

	/*
	 * public Iterable<Box> getAllBoxes() { return boxRepository.findAll(); }
	 * 
	 * public Optional<Box> getById(String boxId) { // return
	 * boxRepository.findById(boxId); return
	 * boxRepository.findById(Long.parseLong(boxId)); }
	 * 
	 * public Iterable<BoxPojo> getAllBoxesWithThingTypes() { Iterable<Box>
	 * boxes = boxRepository.findAll();
	 * 
	 * List<BoxPojo> boxesPojo = new ArrayList(); for (Box box : boxes) {
	 * BoxPojo myBox = new BoxPojo(box.getId()); myBox.setName(box.getName());
	 * myBox.setThingTypeSchema(box.getThingTypeSchema().getId());
	 * myBox.setThingTypes(thingTypeRepository.findAllByBoxId(box.getId()));
	 * boxesPojo.add(myBox); } return boxesPojo; }
	 * 
	 * public Integer getLastKey(Integer boxId) { return
	 * boxRepository.getLastKey(boxId); }
	 */

}
