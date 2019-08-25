package com.qa.employeeapi.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC005_DELETE_DeleteExistingEmployee extends TestBase{

	@BeforeClass
	public void deleteEmployee() {
		
		setup();
		logger.info("**********Started TC005_DELETE_DeleteExistingEmployee*********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		JsonPath jsonPathEval = response.jsonPath();
		String empID = jsonPathEval.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/"+empID);
	}
	
	
	@Test(priority=7)
	public void validateResponseBody() {
		logger.info("**********Validating response body_DeleteExistingEmployee*********");
		String respBody = response.getBody().asString();
		Assert.assertTrue(respBody.contains("successfully! deleted Records"));
		
	}
	
	@Test(priority=8)
	public void validateStatusCode() {
		logger.info("**********Validating status code_DeleteExistingEmployee*********");
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test(priority=9)
	public void validateStatusLine() {
		logger.info("**********Validating status line_DeleteExistingEmployee*********");
		Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("************TC005_DELETE_DeleteExistingEmployee finshed******************");
		
	}
	
}
