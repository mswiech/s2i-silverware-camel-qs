package io.silverware.microservices.demo.bean;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;

import io.silverware.microservices.annotations.Microservice;
import io.silverware.microservices.providers.cdi.MicroservicesStartedEvent;

@Microservice
public class MicroserviceBean {

	private static final Logger log = LogManager.getLogger(MicroserviceBean.class);

	public MicroserviceBean() {
		log.info("MicroserviceBean constructor");
	}

	@PostConstruct
	public void onInit() {
		log.info("MicroserviceBean PostConstruct");
	}

	public String randomNumeric(final int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	public void eventObserver(@Observes MicroservicesStartedEvent event) {
		log.info("MicroserviceBean MicroservicesStartedEvent");
	}

}
