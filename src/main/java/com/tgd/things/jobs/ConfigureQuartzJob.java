package com.tgd.things.jobs;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ConfigureQuartzJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureQuartzJob.class);

	/*
	 * @Bean public JobDetail jobADetails() { return
	 * JobBuilder.newJob(JobOne.class).withIdentity("sampleJobA").storeDurably().
	 * build(); }
	 * 
	 * @Bean public Trigger jobATrigger(JobDetail jobADetails) { return
	 * TriggerBuilder.newTrigger().forJob(jobADetails).withIdentity("TriggerA")
	 * .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * ? * * *")).build();
	 * }
	 */

	@Bean
	public JobDetail jobBDetails() {
		return JobBuilder.newJob(JobMinuterInstance.class).withIdentity("com.tgd.things.jobs.JobMinuterInstance")
				.storeDurably().build();
	}

	@Bean
	public Trigger jobBTrigger(JobDetail jobBDetails) {
		LOGGER.debug("Start jobBTrigger");

		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("somedata", UUID.randomUUID().toString());

		return TriggerBuilder.newTrigger().forJob(jobBDetails).withIdentity("Trigger Sync Instance")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).usingJobData(jobDataMap).build();
	}

}