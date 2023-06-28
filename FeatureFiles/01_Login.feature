@Regression
Feature: To verify the login feature

  @Login
  Scenario: To verify that the login button is disabled
    Given The login button should be disabled with email and password field are empty

  #@Login
  Scenario: To verify the login with invalid credentials
    Given User enters the invalid email and invalid password
    And Taps on the login button
    Then User should see a warning toast

 # @Login
  Scenario: To clear the email and password fields
    Given User clears the email and password fields

 # @Login
  Scenario: To verify the login by tapping skip button
    Given User enters the valid email and valid password
    And Taps on the login button
    And Taps on the skip button to get started
    Then User should be logged in successfully

 @Login
  Scenario: To verify the login by tapping next button
    Given User enters the valid email and valid password
    And Taps on the login button
    And Taps on the next button to get started
    Then User should be logged in successfully
