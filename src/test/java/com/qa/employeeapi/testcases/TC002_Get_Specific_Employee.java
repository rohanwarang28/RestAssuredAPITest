package com.qa.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC002_Get_Specific_Employee extends TestBase{

	
	@BeforeClass
	public void getEmployeeDetails() {
		setup();
		logger.info("************TC002_Get_Specific_Employee started******************");
		
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "http://dummy.restapiexample.com/api/v1/employee/"+empID);
		
	}
	
	@Test
	public void checkResponseData() {
		logger.info("************checking the response body******************");
		String respBody = response.getBody().asString();
		Assert.assertEquals(respBody.contains("67769"), true);
		
	}
	
	@Test
	public void checkStatusCode() {
		
		logger.info("************checking status code******************");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@AfterClass
	public void tearDown() {
		
		logger.info("************TC002_Get_Specific_Employee finished******************");
	}
	
}
