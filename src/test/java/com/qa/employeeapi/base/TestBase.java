package com.qa.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	
	public static RequestSpecification httpRequest;
	public static Response response;
	public int empID=67769;
	
	public Logger logger;
	
	
	public void setup() {
		
		logger = Logger.getLogger("RestAssuredAPITesting");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}
	
}
