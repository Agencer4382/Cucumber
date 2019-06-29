package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeesPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeSteps extends CommonMethods {
	LoginPage login;
	AddEmployeesPage page;
	HomePage hPage;

	@Given("User logged OrangeHrm")
	public void user_logged_OrangeHrm() {
		login = new LoginPage();
		hPage = new HomePage();
		page = new AddEmployeesPage();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("User click on PIM link")
	public void user_click_on_PIM_link() {

		click(hPage.pimBtn);
	}

	@When("User click on Add Employee link")
	public void user_click_on_Add_Employee_lin() {

		click(hPage.addEmp);
	}

	@When("User provide employee details {string} and {string} and {string} and {string} and {string}")
	public void user_provide_employee_details_and_and_and_and(String userName, String mName, String lName,
			String employeeID, String location) {

		sendText(page.firstName, userName);
		sendText(page.middleName, mName);
		sendText(page.lastName, lName);
		sendText(page.employeeId, employeeID);
		click(page.location);
		selectList(page.locationList, location);
	}

	@When("User click on save button")
	public void user_click_on_save_button() {
		click(page.saveBtn);
	}

	@Then("User see employee is added successfully {string} and {string}")
	public void user_see_employee_is_added_successfully_and(String userName, String lName) {
		waitForElementBeClickable(page.empCheck, 20);
		String text = page.empCheck.getText();
		System.out.println("Expected text is :" + text);
		Assert.assertEquals(text, userName + " " + lName);

	}

	@Then("User see following labels")
	public void user_see_following_labels(io.cucumber.datatable.DataTable addEmpLabels) {
		List<String> labels = addEmpLabels.asList();
		for (String label : labels) {
			System.out.println(label);

		}
		List<WebElement> labelList = page.addEmpLabels;
		List<String> labels2 = new ArrayList<>();
		
	 for (WebElement label: labelList) {
		 String labeltxt=label.getText();
		 labels2.add(labeltxt);
		 //System.out.println(labeltxt.replaceAll(".", ""));
	}
	 boolean isEqual = labels.equals(labels2);
	 System.out.println("Labels verification is "+isEqual);
	}

	@When("User provide username,middle name,lastname and location")
	public void user_provide_username_middle_name_lastname_and_location() {
		sendText(page.firstName, "Kevin");
		sendText(page.middleName, "M");
		sendText(page.lastName, "Kerry");
		click(page.location);
		selectList(page.locationList, "Smart Office");
	}

	@When("User click on create login details")
	public void user_click_on_create_login_details() {
		click(page.createLoginDetails);

	}

	@When("User provide all mandatory fields")
	public void user_provide_all_mandatory_fields() {
		sendText(page.conusername, "Kevin");
		sendText(page.password1, "Kevin123@Kev10");
		sendText(page.conpassword, "Kevin123@Kev10");
		click(page.adminRole);
		selectList(page.adminRole, "Global Admin");
		click(page.defESS);
		selectList(page.defESS, "Default ESS");
		click(page.status);
		selectList(page.status, "Enabled");
		click(page.superVisRole);
		selectList(page.superVisRole, "Default Supervisor");
	}

	@When("User click save button")
	public void user_click_save_button() {
		click(page.saveBtn);
	}

}
