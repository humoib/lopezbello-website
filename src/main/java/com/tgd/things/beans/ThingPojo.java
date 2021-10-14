package com.tgd.things.beans;

import java.util.Date;

import com.tgd.things.beans.db.security.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThingPojo {

	protected Long id;

	protected Long key;

	protected String thingKey;


	protected Long thingTypeId;

	protected String thingTypeName;

	protected String humanKey;

	// For REST - mandatory
	protected String boxKey;

	protected Long boxId;
	
	protected String boxName;

	protected String summary;

	protected String analysis;

	protected String description;

	protected Date created;

	protected Date updated;

	protected User creator;
	
	public ThingPojo(Long id) {
		this.id = id;
		this.summary = "BLANK";
		this.created = new Date();
	}

	public ThingPojo() {
		this.id = null;
		this.summary = "BLANK";
	}

	public ThingPojo(Long id, String summary) {
		this.id = id;
		this.summary = summary;
		this.created = new Date();
		this.updated = new Date();
	}

	@Override
	public String toString() {
		return "ThingPojo [id=" + id + ", boxId=" + boxId + ", summary=" + summary + ", created=" + created
				+ ", thingTypeId=" + thingTypeId + "]";
	}

}
