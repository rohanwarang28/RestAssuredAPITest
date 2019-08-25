package com.qa.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.employeeapi.base.TestBase;

import com.qa.employeeapi.utilities.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC003_POST_CreateNewEmployee extends TestBase{

String empName=null;
	
	
	
	@BeforeClass
	public void getEmployeeDetails() {
		setup();
		logger.info("************TC003_POST_CreateNewEmployee started******************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		 empName = TestUtils.empName();
	}
	
	
	@Test(priority=0)
	public void createEmployee() throws InterruptedException {
		
		logger.info("************creating a new Employee******************");
		
		JSONObject obj=new JSONObject();
		
		obj.put("name",empName);
		obj.put("salary", "200000");
		obj.put("age", "26");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());
		
		response = httpRequest.request(Method.POST, "/create");
		logger.info("************New Employee Created******************");
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void checkResponseBodyForCreate() {
		logger.info("************Checking response body for create request******************");
		String respBody = response.getBody().asString();
		Assert.assertEquals(respBody.contains(empName), true);
		
		
	}
	
	
	@Test(priority=2)
	public void checkResponseCodeForCreate() {
		logger.info("************Checking Status code for create request******************");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("************TC003_POST_CreateNewEmployee finshed******************");
		
	}
	
	
}
