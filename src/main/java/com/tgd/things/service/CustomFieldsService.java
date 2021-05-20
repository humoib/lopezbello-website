package com.tgd.things.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgd.things.beans.CustomFieldReduced;
import com.tgd.things.beans.CustomFieldValueReduced;
import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.CustomField;
import com.tgd.things.beans.db.CustomFieldValue;
import com.tgd.things.beans.db.Thing;
import com.tgd.things.beans.db.ThingType;
import com.tgd.things.repository.CustomFieldRepository;
import com.tgd.things.repository.CustomFieldValueRepository;
import com.tgd.things.repository.ThingRepository;

@Service
@Transactional
public class CustomFieldsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFieldsService.class);

	@Autowired
	protected ThingRepository thingRepository;

	@Autowired
	protected CustomFieldRepository customFieldRepository;
	
	@Autowired
	protected CustomFieldValueRepository customFieldValueRepository;

	/**
	 * 
	 * @param thingType
	 * @return
	 */
	public Iterable<CustomField> getCustomFields(ThingType thingType) {
		return customFieldRepository.findAll();
	}

	/**
	 * getAllFields
	 * 
	 * @return
	 */
	public Iterable<CustomField> getAllFields() {
		return customFieldRepository.findAll();
	}

	/**
	 * getAllFieldsFromThingType
	 * 
	 * @return
	 */
	public List<CustomFieldReduced> getAllFieldsFromThingType(ThingType thingType) {
		return customFieldRepository.getAllFieldsFromThingType(thingType.getId());
	}

	/**
	 * getAllFieldsFromThing
	 * 
	 * @return
	 */
	public List<CustomFieldValueReduced> getAllFieldValuesFromThing(Thing thing) {
		return customFieldRepository.getAllFieldValuesFromThing(thing.getId());
	}

	/**
	 * 
	 * @return
	 * 
	 * 		public List<CustomFieldReduced> getMyRows() { return
	 *         customFieldRepository.getMyRows(); }
	 */

	public int updateValue(Thing myThing, String fieldName, String newvalue) {
		LOGGER.debug("## updateValue");

		// Get the field Object
		List<CustomFieldReduced> fields = customFieldRepository.findByName(fieldName);
		for (CustomFieldReduced field : fields) {
			LOGGER.debug("findByName -> FIELD --SEARCHED--: name: {}", field.getName());
		}
		if (fields.size() > 1) {
			LOGGER.warn("Campo repetido para este asunto {}", fieldName);

		} else {
			// TODO: Revisar... Porque aquí úicamente cojo el primero
			CustomFieldReduced toUpdateField = fields.get(0);

			if (myThing.getId() != null) {
				// EDIT THING

				// Search if there is a value
				// yes --> update
				List<CustomFieldValue> values = customFieldValueRepository.findByThingAndField(myThing.getId(),
						Long.parseLong(toUpdateField.getId()));
				if (values.size() == 0) {
					// add
					// no --> insert
					LOGGER.debug("111");
					CustomFieldValue value = new CustomFieldValue();
					value.setThing(thingRepository.findById(myThing.getId()).get());

					LOGGER.debug("222");
					LOGGER.debug(" -- " + toUpdateField.getId());
					LOGGER.debug("--- " + customFieldRepository.findById((long) 1));
					LOGGER.debug("333 " + customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get()
							+ "  "
							+ customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get().getClass());
					LOGGER.debug(" -- " + toUpdateField.getId());

					value.setCustomField(customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get());

					LOGGER.debug("444");
					LOGGER.debug(" newvalue: {}", newvalue);
					if (newvalue != null) {
						value.setValue(newvalue);
						CustomFieldValue retValue = customFieldValueRepository.save(value);
					}
				} else if (values.size() == 1) {
					CustomFieldValue value = values.get(0);
					value.setValue(newvalue);
					customFieldValueRepository.save(value);
				}
			} else {
				// NEW THING
				CustomFieldValue value = new CustomFieldValue();
				value.setThing(thingRepository.findById(myThing.getId()).get());

				LOGGER.debug("222");
				LOGGER.debug(" -- " + toUpdateField.getId());
				LOGGER.debug("--- " + customFieldRepository.findById((long) 1));
				LOGGER.debug("333 " + customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get() + "  "
						+ customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get().getClass());
				LOGGER.debug(" -- " + toUpdateField.getId());

				value.setCustomField(customFieldRepository.findById(Long.parseLong(toUpdateField.getId())).get());

				LOGGER.debug("444");
				LOGGER.debug(" newvalue: {}", newvalue);
				value.setValue(newvalue);
				CustomFieldValue retValue = customFieldValueRepository.save(value);

			}

			// customFieldRepository.find

		}
		return 0;
	}

}
