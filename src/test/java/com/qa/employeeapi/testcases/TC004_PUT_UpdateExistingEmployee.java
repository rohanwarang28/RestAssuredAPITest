package com.qa.employeeapi.testcases;


import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.employeeapi.base.TestBase;
import com.qa.employeeapi.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC004_PUT_UpdateExistingEmployee extends TestBase{
	String empName = TestUtils.empName();
	@BeforeClass
	public void getEmployeeDetails() {
		
		setup();
		logger.info("***********TC004_PUT_UpdateExistingEmployee started************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
	}
	
	@Test(priority=4)
	public void updateEmployeeRecord() throws InterruptedException {
		logger.info("***********Updating employee record************");
		
		JSONObject obj = new JSONObject();
		obj.put("name", empName);
		obj.put("age", 26);
		obj.put("salary", 100000);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		response = httpRequest.request(Method.PUT,"/update/"+empID);
		Thread.sleep(5000);
		logger.info("*************Record updated******************");
	}
	
	@Test(priority=5)
	public void verifyStatusCodeForUpdate() {
		logger.info("Checking response code for update request");
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode);
		
	}
	
	@Test(priority=6)
	public void checkResponseBodyForUpdate() {
		logger.info("Checking response body for update request");
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("***********TC004_PUT_UpdateExistingEmployee finished************");	}
	
	
	
}
