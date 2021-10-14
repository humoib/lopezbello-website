package com.tgd.things.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThingsProperties {

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsProperties.class);

	static Properties props;

	static Date lastUpdated;

	private ThingsProperties() {
	}

	/**
	 * getProperties
	 * 
	 * @return Properties object
	 */
	protected static Properties getProperties() {

		try {
			// Fichero
			// File jiraHome = ComponentAccessor.getComponent(JiraHome.class).getHome();
			// URL resource = this.class.getResource("abc");

//      File propertyFile = new File(resource.toURI()).getAbsolutePath(); 
			// new File(jiraHome, "dynamic-fields.properties");

			// props = new Properties();

			String propertiesFileName = "things.properties";

			URL url = ThingsProperties.class.getClassLoader().getResource(propertiesFileName);
			LOGGER.debug("URL-> " + url);

			File propertyFile = propertyFile = new File(url.getPath());

			// Fecha de actualización del fichero
			if (lastUpdated == null) {
				lastUpdated = new Date();
			}
			if (props == null || new Date(propertyFile.lastModified()).after(lastUpdated)) {
				LOGGER.debug("####### PROPS lectura");
				props = new Properties();
				FileInputStream fileInputStream = new FileInputStream(propertyFile);
				props.load(fileInputStream);

				LOGGER.debug("## prop: {}", props.size());
				lastUpdated = new Date();

			} else {
				LOGGER.trace("####### PROPS no es nulo -> {}", props.size());
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException: {} stack: {}", e.getMessage(), Arrays.toString(e.getStackTrace()));
		} catch (IOException e) {
			LOGGER.error("IOException: {} stack: {}", e.getMessage(), Arrays.toString(e.getStackTrace()));
		}

		return props;
	}

	/**
	 * Obtiene una propiedad por clave
	 * 
	 * @param key Clave de la propiedad
	 * @return String Valor de la propiedad en fichero
	 */
	public static String getProperty(String key) {
		return getProperties().getProperty(key);
	}

}