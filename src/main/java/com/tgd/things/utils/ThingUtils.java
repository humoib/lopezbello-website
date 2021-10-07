package com.tgd.things.utils;

import java.util.Random;

import com.tgd.things.beans.ThingPojo;
import com.tgd.things.beans.db.Thing;

public class ThingUtils {

	/**
	 * 
	 * @param thingDb
	 * @return
	 */
	public static ThingPojo db2pojoThing(Thing thingDb) {
		ThingPojo pojo = new ThingPojo(thingDb.getId());
		pojo.setKey(thingDb.getBox().getBoxKey() + "-" + thingDb.getId());
		pojo.setBoxId(thingDb.getBox().getId().intValue());
		pojo.setThingTypeId(thingDb.getThingType().getId());
		pojo.setSummary(thingDb.getSummary());
		pojo.setCreated(thingDb.getCreated());
		return pojo;
	}

}
