#@Regression
Feature: To verify the forgot password feature

  @ForgotPassword
  Scenario: To verify forgot password with invalid email
    Given User taps on the forgot password button
    And Enters the invalid email
    And Taps on the reset password button
    Then A toast with a waring message should be displayed
    And User taps on the back to login button
    Then User should be land on the login page

  @ForgotPassword
  Scenario: To reset the password
    Given User taps on the forgot password button
    And Enters the valid email
    And Taps on the reset password button
    Then Reset link should be sent successfully
    And User taps on the back to login button
    Then User should be land on the login page
  #@ForgotPassword
  #Scenario: To go back log in tab from forgot password tab
    #Given User taps on the back to login button
    #Then User should be land on the login page
