package com.tgd.things.beans.db;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOM_FIELD_LARGE_VALUE")
@Getter
@Setter
@AllArgsConstructor
public class CustomFieldLargeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CFLV_ID", length = 20)
	private Long id;

	@OneToOne
	private Thing thing;

	@OneToOne
	private CustomField customField;

	@Column(name = "CFLV_VALUE", length = 100, nullable = false)
	private String value;

	public CustomFieldLargeValue() {
	}

	@Override
	public String toString() {
		return "Custom Field Large Value {" + "id=" + id + ", value='" + value.substring(1, 30) + "..." + '\'' + " '}'";
	}

}