package com.tgd.things.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tgd.things.plugins.PhotoServicePlugin;

@Component
public class Initializer {

	private String someInitialValue;
	private String anotherManagedValue;

	private String valor;

	public Initializer(@Value("someInitialValue") String someInitialValue,
			@Value("anotherValue") String anotherManagedValue) {

		this.someInitialValue = someInitialValue;
		this.anotherManagedValue = anotherManagedValue;
	}

	public PhotoServicePlugin initClass() {
		return new PhotoServicePlugin(anotherManagedValue);
	}
}