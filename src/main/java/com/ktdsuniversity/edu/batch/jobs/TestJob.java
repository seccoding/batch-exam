package com.ktdsuniversity.edu.batch.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniversity.edu.batch.beans.Beans;
import com.ktdsuniversity.edu.batch.service.TestService;

public class TestJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(TestJob.class);
	
	private TestService testService;
	
	public TestJob() {
		testService = Beans.getInstance().getBean("testService");
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("TestJob Start");
		
		String text = testService.getText();
		
		logger.info("TestJob 처리 중... {}", text);
		
		logger.info("TestJob End");
	}

}
