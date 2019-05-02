package es.upm.dit.isst.rgpd.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

import es.upm.dit.isst.rgpd.util.jobs.TimeoutJob;

@WebListener
public class QuartzListener implements ServletContextListener {
	Scheduler scheduler = null;

	@Override
	public void contextInitialized(ServletContextEvent servletContext) {
		System.out.println("Context Initialized");

		try {
			// Setup the Job class and the Job group
			JobDetail job = newJob(TimeoutJob.class).withIdentity(
					"CronQuartzJob", "Group").build();

			// Create a Trigger that fires every 5 minutes.
			Trigger trigger = newTrigger()
					.withIdentity("TriggerName", "Group")
					.withSchedule(simpleSchedule()
							.withIntervalInHours(24)
							.repeatForever())
					.build();

			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		System.out.println("Context Destroyed");
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
