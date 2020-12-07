package com.tgd.things.beans.db;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOM_FIELD")
@Getter
@Setter
@AllArgsConstructor
public class CustomField {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CFI_ID", length = 20, nullable = false)
	private Long id;

	@Column(name = "CFI_NAME", length = 100, nullable = false)
	private String name;

	@Column(name = "CFI_KEY", length = 100, nullable = false)
	private String key;

	@Column(name = "CFI_TYPE", length = 100, nullable = false)
	private String type;

	public CustomField() {
	}

	@Override
	public String toString() {
		return " Custom Field {" + "id=" + id + ", name='" + name + '\'' + " '}'";
	}

}