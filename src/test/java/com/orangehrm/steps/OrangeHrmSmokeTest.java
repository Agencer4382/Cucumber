package com.orangehrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.utils.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHrmSmokeTest{
	
WebDriver driver;
	
	@Given("Open chrome and start application")
	public void open_chrome_and_start_application() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	  
	}

	@When("User enter valid {string} and valid {string}")
	public void user_enter_valid_username_and_valid_password(String uname, String pass) {
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
	    
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
		driver.findElement(By.id("btnLogin")).click();
	   
	}
	@Then("brorwser should be able to close")
	public void brorwser_should_be_able_to_close() {
	  
		driver.close();
	}


}
