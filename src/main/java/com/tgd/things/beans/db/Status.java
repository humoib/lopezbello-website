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
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STA_ID", length = 20)
	private Long id;

	@Column(name = "STA_NAME", nullable = false)
	private String name;

	@Column(name = "STA_CATEGORY", nullable = false)
	private int category;

	@Column(name = "STA_DESCRIPTION")
	private String description;

	@Column(name = "STA_CREATED_DATETIME", nullable = false)
	private Date created;

	public Status() {
	}

	@Override
	public String toString() {
		return " Status {" + "id=" + id + "'}'";
	}

}