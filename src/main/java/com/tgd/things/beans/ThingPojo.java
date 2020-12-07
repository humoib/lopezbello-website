package com.tgd.things.beans;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThingPojo {

	Long id;

	Integer boxId;

	String humanKey;

	protected String summary;

	protected Date created;

	Long thingTypeId;

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
	}

	@Override
	public String toString() {
		return "ThingPojo [id=" + id + ", boxId=" + boxId + ", summary=" + summary + ", created=" + created
				+ ", thingTypeId=" + thingTypeId + "]";
	}

}
