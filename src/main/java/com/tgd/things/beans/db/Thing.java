package com.tgd.things.beans.db;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.tgd.things.beans.db.security.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "THING")
@Getter
@Setter
@AllArgsConstructor
public class Thing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THI_ID", length = 20, nullable = false)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Box box;

	@Column(name = "THI_KEY", length = 10, nullable = false)
	private Integer key;

	@Column(name = "THI_SUMMARY", length = 500, nullable = false)
	private String summary;

	@ManyToOne
	@JoinColumn(name = "THI_CREATOR") // , nullable = false
	// @ManyToOne(optional = false)
	// (optional = false)
	private User creator;

	@Column(name = "THI_CREATED", nullable = false)
	private Date created;

	@Column(name = "THI_UPDATED")
	private Date updated;

	@Column(name = "THI_CLOSED")
	private Date closed;

	@ManyToOne(optional = false)
	private ThingType thingType;

	// @OneToMany(cascade = CascadeType.ALL)
	// private List<ThingComment> thingComment;

	public Thing() {
	}

	public ThingType getThingType() {
		return this.thingType;
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + ", box=" + box + ", key=" + key + ", summary=" + summary + ", created=" + created
				+ ", updated=" + updated + ", closed=" + closed + ", thingType=" + thingType.getName() + "]";
	}

}