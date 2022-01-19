package com.tgd.things.beans.db;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOM_FIELD_VALUE")
@Getter
@Setter
@AllArgsConstructor
public class CustomFieldValue {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//@SequenceGenerator(name = "SEQ", sequenceName = "KEY_GEN_SEQ", initialValue = 1, allocationSize = 500)
	private Long id;

	@OneToOne
	private Thing thing;

	@OneToOne
	private CustomField customField;

	@Column(name = "CFV_VALUE", length = 100, nullable = false)
	private String value;

	public CustomFieldValue() {
	}

	@Override
	public String toString() {
		return "Custom Field Value {" + "id=" + id + ", value='" + value + '\'' + " '}'";
	}

}