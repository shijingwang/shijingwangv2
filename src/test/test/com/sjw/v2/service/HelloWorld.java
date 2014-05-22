package test.com.sjw.v2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
	private static Logger logger = LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {
		logger.info("Hello, World!");
		System.out.println("Abc");
	}
}