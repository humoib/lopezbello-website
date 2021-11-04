package com.tgd.things.beans.db;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WORKFLOW")
@Getter
@Setter
@AllArgsConstructor
public class Workflow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WFL_ID", length = 20, nullable = false)
	private Long id;

	@Column(name = "WFL_NAME", length = 500, nullable = false)
	private String name;

	@Column(name = "WFL_CREATED_DATETIME", nullable = false)
	private Date created;

	// status
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "WFL_STATUS")
	private List<Status> statusList;

	public Workflow() {
	}

	@Override
	public String toString() {
		return " Workflow {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}