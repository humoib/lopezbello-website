package com.tgd.things.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ThingsAppProperties {

	@Autowired
	public ThingsAppProperties(@Value("${context}") String context) {
		this.context = context;
		System.out.println("================== " + context + "================== ");
	}

	// @Value("${variable.secret-var}")
	// private String mySecretVar;

	@Value("${baseUrl:default}")
	private String baseUrl;

	@Value("${context}")
	private static String context;

	@Value("${valor}")
	private String valor;

	public void printVariable() {
		System.out.println("============================================");
		// System.out.format("My secret variable is: %s\n", mySecretVar);
		System.out.format("My baseUrl variable is: %s\n", baseUrl);
		System.out.format("My valor variable is: %s\n", valor);

		System.out.println("============================================");
	}

	public static String getContext() {
		return context;
	}

}