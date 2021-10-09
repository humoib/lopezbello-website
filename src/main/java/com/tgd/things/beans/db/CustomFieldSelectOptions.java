package com.tgd.things.beans.db;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOM_FIELD_SELECT_OPTIONS")
@Getter
@Setter
@AllArgsConstructor
public class CustomFieldSelectOptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CFO_ID", length = 20, nullable = false)
	private Long id;

	@ManyToOne
	private CustomField customField;

	@Column(name = "CFO_VALUE", length = 100, nullable = false)
	private String value;

	public CustomFieldSelectOptions() {
	}

	@Override
	public String toString() {
		return " Custom Field Select Opion {" + "id=" + id + ", value='" + value + '\'' + " '}'";
	}

}