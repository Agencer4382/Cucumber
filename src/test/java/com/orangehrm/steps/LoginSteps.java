package com.orangehrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods {
	LoginPage login;

	@Given("User navigated to OrangeHrm")
	public void user_navigated_to_OrangeHrm() {

		setUp();
	}

	@Given("User see OrangeHrm logo")
	public void user_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("User click login button")
	public void user_click_login_button() {
		click(login.loginBtn);

	}

	@Then("User logged succesfully")
	public void user_logged_succesfully() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}

	@Then("Close the browser")
	public void close_the_browser() {
		tearDown();
	}

	@When("User enter invalid username and password")
	public void user_enter_invalid_username_and_password() {
		sendText(login.userName, "Test");
		sendText(login.password, "Test123");
	}

	@Then("User see error message is displayed")
	public void user_see_error_message_is_displayed() {
		Assert.assertTrue(login.message.isDisplayed());
		String errorText = login.message.getText().trim();
		Assert.assertEquals("Invalid Credentials", errorText);

	}
	@When("User enter invalid username and password User see errorMessage")
	public void user_enter_invalid_username_and_password_User_see_errorMessage(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String,String>> data=dataTable.asMaps(String.class,String.class);
	  
	   for(int i=0; i<data.size(); i++) {
		  sendText(login.userName, data.get(i).get("UserName"));
		   sendText(login.password,data.get(i).get("Password"));
		   click(login.loginBtn);
		   String errorMessage=login.message.getText().trim();
		   Assert.assertEquals(errorMessage, data.get(i).get("ErrorMessage"));

		   
	   }
	}
	

}
