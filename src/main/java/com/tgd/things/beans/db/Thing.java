package com.tgd.things.beans.db;

import java.util.Date;

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
	
	
	@GeneratedValue(generator="SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="SEQUENCE_GENERATOR",sequenceName="SEQ_THI_ID", allocationSize=100)
    
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "SEQ_THI_ID", sequenceName = "SEQ_THI_ID", allocationSize = 1)
	
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "THI_ID", length = 20, nullable = true)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	private Box box;

	@Column(name = "THI_KEY", length = 10, nullable = false)
	private Long key;

	@Column(name = "THI_SUMMARY", length = 500, nullable = false)
	private String summary;

	@ManyToOne(cascade = CascadeType.ALL)
	private Status status;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "THI_ANALYSIS")
	private String analysis;

	@ManyToOne
	@JoinColumn(name = "THI_CREATOR") // , nullable = false
	// @ManyToOne(optional = false)
	// (optional = false)
	private User creator;

	@Column(name = "THI_CREATED_DATETIME", nullable = false)
	private Date created;

	@Column(name = "THI_UPDATED_DATETIME")
	private Date updated;

	@Column(name = "THI_DELIVERY_DATETIME")
	private Date delivery;

	@Column(name = "THI_CLOSED_DATETIME")
	private Date closed;

	@ManyToOne(optional = false)
	private ThingType thingType;

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