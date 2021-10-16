package com.tgd.things.beans.db;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STATUS")
@Getter
@Setter
@AllArgsConstructor
public class ThingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STA_ID", length = 20, nullable = false)
	private Long id;

	//@ManyToMany(cascade = CascadeType.ALL)
	//private List<Thing> thing;

	@Column(name = "STA_NAME", nullable = false)
	private String name;

	@Column(name = "STA_CATEGORY", nullable = false)
	private int category;

	@Column(name = "STA_DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "STA_CREATED_DATETIME", nullable = false)
	private Date created;

	public ThingStatus() {
	}

	@Override
	public String toString() {
		return " Thing Status {" + "id=" + id + "'}'";
	}

}