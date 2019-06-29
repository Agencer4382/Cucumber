package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeesPage extends BaseClass {
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    public WebElement createLoginDetails;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    @FindBy(xpath="//*[@id=\"username\"]")
    public WebElement conusername;
    
    @FindBy(xpath="//*[@id=\"password\"]")
    public WebElement password1;
   
    @FindBy(xpath="//*[@id=\"confirmPassword\"]")
    public WebElement conpassword;
     
    @FindBy(xpath="//*[@id=\"status_inputfileddiv\"]/div/input")
    public WebElement status;
    
    @FindBy(xpath="//*[@id=\"essRoleId_inputfileddiv\"]/div/input")
    public WebElement defESS;
    
    @FindBy(xpath="//*[@id=\"supervisorRoleId_inputfileddiv\"]/div/input")
    public WebElement superVisRole;
    
    @FindBy(xpath="//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    public WebElement adminRole;
   
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']")
    public List<WebElement> addEmpLabels;

    
    public AddEmployeesPage() {
        PageFactory.initElements(driver,this);
    }
}
