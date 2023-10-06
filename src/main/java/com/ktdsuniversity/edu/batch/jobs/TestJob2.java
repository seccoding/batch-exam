package com.ktdsuniversity.edu.batch.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktdsuniversity.edu.batch.beans.Beans;
import com.ktdsuniversity.edu.batch.service.TestService;

public class TestJob2 implements Job {

	private static final Logger logger = LoggerFactory.getLogger(TestJob2.class);
	
	private TestService testService;
	
	public TestJob2() {
		testService = Beans.getInstance().getBean("testService");
	}
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("TestJob2 Start");
		
		String text = testService.getText();
		
		logger.info("TestJob2 처리 중... {}", text);
		
		logger.info("TestJob2 End");
	}

}
