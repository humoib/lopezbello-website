package com.tgd.things.beans.db;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THING_STATUS_SCHEMA")
@Getter
@Setter
@AllArgsConstructor
public class ThingStatusSchema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TSS_ID", length = 20, nullable = false)
	private Long id;

	@Column(name = "TSS_NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "TSS_DESCRIPTION", length = 200)
	private String description;

//	@OneToMany(targetEntity = ThingType.class)
//	@JoinColumn(name = "TSS_DESCRIPTION", length = 200)
//	private Set<ThingType> thingType;

	public ThingStatusSchema() {
	}

	@Override
	public String toString() {
		return "Thing Status Schema {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}