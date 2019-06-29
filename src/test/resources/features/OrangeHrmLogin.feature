Feature: OrangeHRM smoke scenario

Scenario: Test login with valid credentials
Given Open chrome and start application
When User enter valid "Admin" and valid "admin123"
Then User should be able to login successfully
And brorwser should be able to close