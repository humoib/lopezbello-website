package com.tgd.things.beans.db;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOX")
@Getter
@Setter
@AllArgsConstructor
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOX_ID", length = 20, nullable = false)
	private Long id;

	@Column(name = "BOX_KEY", length = 10, nullable = false)
	private String boxKey;

	@Column(name = "BOX_NAME", length = 500, nullable = false)
	private String name;

	@Column(name = "BOX_CREATED", nullable = false)
	private Date created;

	@ManyToOne(optional = false)
	private ThingTypeSchema thingTypeSchema;

	@Column(name = "BOX_LAST_KEY")
	private Integer lastKey;

	// 1 - Stuff
	// 2 - Process
	// 3 - Software
	// 4 - Service Management
	// 5 - Photo
	// 6 - Places
	@Column(name = "BOX_TYPE", length = 50)
	private Integer type;

	@Column(name = "BOX_VIEW", length = 50)
	private String view;

	@Column(name = "BOX_COLOUR", length = 50)
	private String colour;

	public Box() {
	}

	@Override
	public String toString() {
		return " Box {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}