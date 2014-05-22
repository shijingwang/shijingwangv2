package test.com.sjw.v2.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sjw.v2.service.UserService;

public class LogTest {

	static final Logger log = LogManager.getLogger(UserService.class);

	public void testLog() {
		log.info("***************************");
		log.info("获取用户信息:%s", "user");
	}

	public static void main(String args[]) {
		LogTest lt = new LogTest();
		lt.testLog();
		System.out.println("Abc");
	}

}
