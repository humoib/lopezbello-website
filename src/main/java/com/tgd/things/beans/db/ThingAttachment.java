package com.tgd.things.beans.db;

import java.util.Date;

import javax.persistence.*;

import com.tgd.things.beans.db.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ATTACHMENT")
@Getter
@Setter
@AllArgsConstructor
public class ThingAttachment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ATT_ID", length = 20)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Thing thing;

	@Column(name = "ATT_CREATED_DATETIME", nullable = false)
	private Date created;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User actor;

	@Column(name = "ATT_FILENAME", nullable = false)
	private String filename;

	public ThingAttachment() {
	}

	@Override
	public String toString() {
		return " Thing Attachment {" + "id=" + id + "'}'";
	}

}
