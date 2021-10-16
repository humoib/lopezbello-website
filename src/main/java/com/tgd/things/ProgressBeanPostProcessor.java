package com.tgd.things;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import rx.Observable;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

class ProgressBeanPostProcessor implements BeanPostProcessor, ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(ProgressBeanPostProcessor.class);

	private static final Subject<String, String> beans = ReplaySubject.create();

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		beans.onNext(beanName);
		return wrapIfServletContainerFactory(bean);
	}

	private Object wrapIfServletContainerFactory(Object bean) {
		if (bean instanceof ServletWebServerFactory) {
			return wrap((ServletWebServerFactory) bean);
		} else {
			return bean;
		}
	}

	private ServletWebServerFactory wrap(ServletWebServerFactory factory) {
		if (factory instanceof TomcatServletWebServerFactory) {
			((TomcatServletWebServerFactory) factory).addContextValves(new ProgressValve());
		}
		return initializers -> {
			final WebServer container = factory.getWebServer(initializers);
			log.debug("Eagerly starting {}", container);
			container.start();
			return container;
		};
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		beans.onCompleted();
	}

	static Observable<String> observe() {
		return beans;
	}

}