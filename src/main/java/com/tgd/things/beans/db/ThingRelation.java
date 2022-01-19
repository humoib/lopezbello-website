package com.tgd.things.beans.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "THING_RELATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThingRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private Long sourceThingId;

	@Column(nullable = false)
	private Long targetThingId;

	private Integer type;

}