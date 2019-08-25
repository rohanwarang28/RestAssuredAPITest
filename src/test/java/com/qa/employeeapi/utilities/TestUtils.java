package com.qa.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import com.qa.employeeapi.base.TestBase;

public class TestUtils extends TestBase{

	public static String empName() {
		
		return RandomStringUtils.randomAlphabetic(3);
	}
	
}
