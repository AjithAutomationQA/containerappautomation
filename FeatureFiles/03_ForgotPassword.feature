@ForgotPassword
Feature: To verify the forgot password feature

  @Smoke
  Scenario: To reset the password
    Given User taps on the forgot password button
    And Enters the valid email
    And Taps on the reset password button
    Then Reset link should be sent successfully
