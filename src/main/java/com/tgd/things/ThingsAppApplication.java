package com.tgd.things;

import java.util.Arrays;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.tgd.things.config.ThingsAppProperties;

@EnableAutoConfiguration
// @EnableJpaRepositories
@EnableSpringConfigured
@SpringBootApplication
@SpringBootConfiguration
// @ComponentScan("com.tgd.things")
// @ComponentScan
@Configuration
public class ThingsAppApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThingsAppApplication.class);

	@Autowired
	ApplicationContextProvider applicationContextProvider;

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ThingsAppApplication.class, args);
		
		//displayAllBeans();

		// if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
		// LOGGER.debug("HELLO");
		// }

		ThingsAppProperties bean = context.getBean(ThingsAppProperties.class);
		bean.printVariable();

	}

	@Profile("dev")
	@Bean
	public ApplicationRunner devApplicationRunner() {
		LOGGER.debug("-------------------------------- ApplicationRunner ...");

		return null;
	}

	/**
	 * Display All Beans
	 * 
	 */
	public static void displayAllBeans() {
		if (applicationContext != null) {
			String[] allBeanNames = applicationContext.getBeanDefinitionNames();
			for (String beanName : allBeanNames) {
				LOGGER.trace("BEAN: {}", beanName);
			}
		}
	}

	@Bean
	public ProgressBeanPostProcessor progressBeanPostProcessor() {
		return new ProgressBeanPostProcessor();
	}

}
