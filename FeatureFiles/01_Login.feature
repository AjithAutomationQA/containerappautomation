Feature: To verify the login feature

  @Smoke
  Scenario: To verify that the login button is disabled
    Given User opens the app
    And The login button should be disabled with email and password field empty

  @Smoke
  Scenario: To verify the login with invalid credentials
    Given User enters the invalid email and invalid password
    And Taps on the login button
    Then User should see a warning toast

  @Smoke @Login
  Scenario: To verify the login with valid credentials
    Given User enters the valid email and valid password
    And Taps on the login button
    Then User should be logged in successfully
