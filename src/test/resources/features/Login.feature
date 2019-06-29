#Author: syntax team     //john.smith@wellsfargo.com
@sprint3
Feature: Login

Background:
Given User see OrangeHrm logo

@smoke @test
Scenario: Valid login
When User enter valid username and password
When User click login button 
Then User logged succesfully


@regression @login
Scenario: Invalid login
When User enter invalid username and password
And User click login button 

@error
Scenario: Error message Validation
When User enter invalid username and password User see errorMessage
|UserName|Password|ErrorMessage|
|Admin|Admin123|Invalid Credentials|
|Admin1|com123|Invalid Credentials|