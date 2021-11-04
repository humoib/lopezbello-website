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
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Box;
import com.tgd.things.beans.db.Status;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.repository.BoxRepository;
import com.tgd.things.repository.ThingTypeRepository;
import com.tgd.things.repository.ThingTypeSchemaRepository;

@Service
@Transactional
public class ThingStatusService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingStatusService.class);

	@Autowired
	protected BoxRepository boxRepository;

	@Autowired
	protected ThingTypeRepository thingTypeRepository;


}
