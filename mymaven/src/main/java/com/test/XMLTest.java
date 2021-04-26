package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.controller.StatementController;
public class XMLTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		StatementController ct = (StatementController)appCon.getBean("statementController");
		String result = ct.test();
		System.out.println(result);
	}
}