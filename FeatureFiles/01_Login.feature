@Regression
Feature: To verify the login feature

  @Login
  Scenario: To verify that the login button is disabled
    Given The login button should be disabled with email and password field are empty

  @Login
  Scenario: To verify the login with invalid email format
    Given User enters the invalid email format and valid password
    And Taps on the login button
    Then User should see a warning toast for invalid email format
    And User clears the email and password fields

  @Login
  Scenario: To verify the login with invalid email credentials
    Given User enters the invalid email and valid password
    And Taps on the login button
    Then User should see a warning toast for invalid email
    And User clears the email and password fields

  @Login
  Scenario: To verify the login with invalid password credentials
    Given User enters the valid email and invalid password
    And Taps on the login button
    Then User should see a warning toast for invalid password
    And User clears the email and password fields

  @Login
  Scenario: To verify the login with invalid credentials
    Given User enters the invalid email and invalid password
    And Taps on the login button
    Then User should see a warning toast for invalid credentials
    And User clears the email and password fields

  #@Login  @test
  #Scenario: To clear the email and password fields
  #Given User clears the email and password fields
  #@Login
  #Scenario: To verify the login by tapping skip button
    #Given User enters the valid email and valid password
    #And Taps on the login button
    #And Taps on the skip button to get started
    #Then User should be logged in successfully

  @Login 
  Scenario: To verify the login by tapping next button
    Given User enters the valid email and valid password
    And Taps on the login button
    And Taps on the next button to get started
    Then User should be logged in successfully
