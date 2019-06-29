#Author: syntax team     //john.smith@wellsfargo.com
@addemployee @sprint5
Feature: Add Employee smoke scenario


Background:
Given User logged OrangeHrm
When User click on PIM link 
And User click on Add Employee link

@smoke
Scenario Outline: Add Employee
When User provide employee details "<userName>" and "<mName>" and "<lName>" and "<employeeID>" and "<location>"
And User click on save button
Then User see employee is added successfully "<userName>" and "<lName>"

Examples: 
|userName|mName|lName |employeeID|location    |
|Hary    |L    |KUR   |2000730   |Pin Office  |
|Keryy   |K    |COOORY|2004521   |West Office |
|Golden  |J    |TIE   |2003683   |Smart Office|
|Tom     |D    |PUTER |2003195   |Cube Office |


@smoke
Scenario: Add Employee and Create Login Deatils
When User provide username,middle name,lastname and location
And User click on create login details
And User provide all mandatory fields 
And User click save button

@regression @temp
Scenario: Add Employee Labels Verification
Then User see following labels
|First Name|
|Middle Name|
|Last Name|
|Employee Id|
|Location|