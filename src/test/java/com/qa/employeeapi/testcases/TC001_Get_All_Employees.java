package com.qa.employeeapi.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC001_Get_All_Employees extends TestBase{

	
	//Getting all the employees
	@BeforeClass
	public void getEmpDetails() throws InterruptedException {
		setup();
		logger.info("***********started TC001_Get_All_Employees**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(5000);
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("************checking response body*****************");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("************checking status code*****************");
		int statusCode = response.getStatusCode();
		logger.info("Status code ==>" + statusCode);
		Assert.assertEquals(200, statusCode);
	}
	
	
	@Test
	public void checkresponseTime() {
		
	long respTime = response.getTime();
	
	System.out.println(respTime);
	if(respTime>2000)
	System.out.println("Response time greater than 2 sec");
	
	}
	
	
	@AfterClass
	public void tearDown() {
		
		logger.info("*********TC001_Get_All_Employees ended**********");
	}
	
}
