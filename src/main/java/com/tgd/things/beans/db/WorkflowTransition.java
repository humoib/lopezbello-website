package com.tgd.things.beans.db;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WORKFLOW_TRANSITION")
@Getter
@Setter
@AllArgsConstructor
public class WorkflowTransition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRA_ID", length = 20)
	private Long id;

	@Column(name = "TRA_NAME", length = 500, nullable = false)
	private String name;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "WFL_ID")
	private Workflow workflow;

	public WorkflowTransition() {
	}

	@Override
	public String toString() {
		return " Workflow Transition {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}