package com.orangehrm.steps;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void start(Scenario scenario) {
		BaseClass.setUp();
		System.out.println("Srtaring test : "+scenario.getName());

	}

	@After
	public void end(Scenario scenario) {
		
		System.out.println("Ending test : "+scenario.getName());
		if(!scenario.isFailed()) {
			byte[] shot=CommonMethods.takeScreenshot();
			scenario.embed(shot, "image/png");
			
		}
		BaseClass.tearDown();

	}

}
