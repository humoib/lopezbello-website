/*
 * jiracloud-seiso-app
 *
 * Copyright (C) 2014 eXcentia Consultoria S.L.
 * All rights reserved.
 *
 * contact@excentia.es
 */
package com.tgd.things.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobMinuterInstance implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobMinuterInstance.class);

	@Override
	public void execute(JobExecutionContext context) {
		LOGGER.info("## JobMinuterInstance::execute (each minute)");

	}

}
