package com.tgd.things.beans.db;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THING_TYPE_SCHEMA")
@Getter
@Setter
@AllArgsConstructor
public class ThingTypeSchema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TTS_ID", length = 20, nullable = false)
	private Long id;

	@Column(name = "TTS_NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "TTS_DESCRIPTION", length = 200)
	private String description;

	@ManyToMany(targetEntity = ThingType.class)
	private Set<ThingType> thingType;

	public ThingTypeSchema() {
	}

	@Override
	public String toString() {
		return "Thing Type Schema {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}