package com.tgd.things.beans;

import java.util.Date;
import java.util.List;

import com.tgd.things.beans.db.ThingType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Value
public class BoxPojo {

	Long id;

	protected String name;

	protected String boxKey;

	protected Date created;

	Long thingTypeSchema;

	List<ThingType> thingTypes;

	public BoxPojo() {
		this.id = null;
		this.name = "BLANK";
		this.created = new Date();
	}

	public BoxPojo(Long id) {
		this.id = id;
		this.created = new Date();
	}

	public BoxPojo(Long id, String name) {
		this.id = id;
		this.name = name;
		this.created = new Date();
	}

}
