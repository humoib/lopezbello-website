package com.tgd.things.beans;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCommentPojo {

	Long id;

	Long thingId;

	String comment;

	private Date created;

	public NewCommentPojo() {
		this.id = id;
		this.comment = "EMPTY";
		this.created = new Date();
	}

	@Override
	public String toString() {
		return "NewCommentPojo [id=" + id + ", thingId=" + thingId + ", created=" + created + "]";
	}

}
