package com.orangehrm.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

	@Given("user navigated to the Google")
	public void user_navigated_to_the_Google() {
		System.out.println("I am on google page");
	}

	@When("user type search item")
	public void user_type_search_item() {
		System.out.println("User search for item");
	}

	@When("user click on google search button")
	public void user_click_on_google_search_button() {
		 System.out.println("clicked search button");
	}

	@Then("user see search result are displayed")
	public void user_see_search_result_are_displayed() {
		System.out.println("Results are displayed");
	}
	
	
}
