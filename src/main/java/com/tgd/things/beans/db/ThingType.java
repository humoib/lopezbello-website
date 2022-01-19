package com.tgd.things.beans.db;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THING_TYPE")
@Getter
@Setter
@AllArgsConstructor
public class ThingType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TTY_ID", length = 20)
	private Long id;

	@Column(name = "TTY_NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "TTY_DESCRIPTION", length = 200)
	private String description;

	@ManyToMany(targetEntity = CustomField.class)
	private Set<CustomField> customField;

	// status ??
	@OneToMany(targetEntity = ThingType.class)
	@JoinColumn(name = "TTY_STATUS_SCHEMA")
	private List<ThingStatusSchema> statusSchema;

	public ThingType() {
	}

	@Override
	public String toString() {
		return "Thing Type {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}