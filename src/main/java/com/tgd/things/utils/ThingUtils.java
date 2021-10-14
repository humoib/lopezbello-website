package com.tgd.things.utils;

import java.util.ArrayList;
import java.util.List;

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

		pojo.setKey(thingDb.getKey());
		pojo.setThingTypeId(thingDb.getThingType().getId());
		pojo.setThingTypeName(thingDb.getThingType().getName());

		pojo.setThingKey(thingDb.getBox().getBoxKey() + "-" + thingDb.getKey());

		pojo.setBoxId(thingDb.getBox().getId());
		pojo.setBoxKey(thingDb.getBox().getBoxKey());
		pojo.setBoxName(thingDb.getBox().getName());

		pojo.setThingTypeId(thingDb.getThingType().getId());
		pojo.setSummary(thingDb.getSummary());

		pojo.setCreated(thingDb.getCreated());
		pojo.setCreator(thingDb.getCreator());

		return pojo;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public static List<ThingPojo> getdbList2pojoThing(List<Thing> thingsDb) {
		List<ThingPojo> thingPojo_list = new ArrayList();
		for (Thing thingDb : thingsDb) {
			thingPojo_list.add(ThingUtils.db2pojoThing(thingDb));
		}
		return thingPojo_list;
	}

}
