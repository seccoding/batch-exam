package com.ktdsuniversity.edu.batch.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 이 클래스는 수정하지 마세요!
 */
public class Beans {

	private static Beans beansInstance;
	private ApplicationContext ctx;
	private static Object lock = new Object();
	
	private Beans() {
		ctx = new ClassPathXmlApplicationContext("classpath:/batchContext.xml");
	}
	
	public static synchronized Beans getInstance() {
		synchronized (lock) {
			if (beansInstance == null) {
				beansInstance = new Beans();
			}
			
			return beansInstance;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName) {
		return (T) this.ctx.getBean(beanName);
	}
	
}
