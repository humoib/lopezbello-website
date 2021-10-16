package com.tgd.things.beans.db;

import java.util.Date;

import javax.persistence.*;

import com.tgd.things.beans.db.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
@AllArgsConstructor
public class ThingComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COM_ID", length = 20, nullable = false)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Thing thing;

	@Column(name = "COM_CREATED_DATETIME", nullable = false)
	private Date created;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User actor;

	@Lob
	@Column(name = "COM_TEXT", nullable = false)
	@Basic(fetch = FetchType.LAZY)
	private String comment;

	public ThingComment() {
	}

	@Override
	public String toString() {
		return " Thing Comment {" + "id=" + id + "'}'";
	}

}