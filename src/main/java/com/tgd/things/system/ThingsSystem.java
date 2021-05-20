package com.tgd.things.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public final class ThingsSystem {
	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsSystem.class);

	private static int defconLevel;

	@Value("${baseUrl}")
	private static String baseUrl;

	@Value("${valor}")
	private static String valor;

	// valor=test

	// ThingsSystem(@Value("${helloMessage}") String helloMessage) {
	// LOGGER.info("--valor: " + valor);
	// LOGGER.info("---" + helloMessage);
	// }

	ThingsSystem() {
		LOGGER.info("## CONSTRUCTOR ThingsSystem");
		LOGGER.info("--valor: " + valor);
		LOGGER.info("---" + this.baseUrl);
	}

	static int getDefconLeve() {
		return defconLevel;
	}

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static String getValor() {
		return valor;
	}

	/****************************
	 **** JVM info *************
	 ****************************/

	// date
	// memory
	// cpu

}
