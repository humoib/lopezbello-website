package com.tgd.things.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ThingsAppProperties {

	// @Value("${variable.secret-var}")
	// private String mySecretVar;

	@Value("${baseUrl}")
	private String baseUrl;

	@Value("${valor}")
	private String valor;

	public void printVariable() {
		System.out.println("============================================");
		// System.out.format("My secret variable is: %s\n", mySecretVar);
		System.out.format("My baseUrl variable is: %s\n", baseUrl);
		System.out.format("My valor variable is: %s\n", valor);

		System.out.println("============================================");
	}

}