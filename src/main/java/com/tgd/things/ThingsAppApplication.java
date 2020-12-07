package com.tgd.things;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
//@EnableJpaRepositories
@EnableSpringConfigured
@SpringBootApplication
@SpringBootConfiguration
@ComponentScan("com.tgd.things")
// @ComponentScan
@Configuration
public class ThingsAppApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsAppApplication.class);

	@Autowired
	ApplicationContextProvider applicationContextProvider;

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ThingsAppApplication.class, args);
		displayAllBeans();
	}

	public static void displayAllBeans() {
		if (applicationContext != null) {
			String[] allBeanNames = applicationContext.getBeanDefinitionNames();
			for (String beanName : allBeanNames) {
				LOGGER.info("BEAN: {}", beanName);
			}
		}
	}
}
