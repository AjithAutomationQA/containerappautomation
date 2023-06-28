@Regression
Feature: To verify the logout feature

  @Logout
  Scenario: To cancel the logout
    Given User taps on the settings button
    And User taps on the logout button
    And taps cancel button
    Then User should stay in the settings tab

  @Logout
  Scenario: To logout the app
    And User taps on the logout button
    And taps yes logout button
    Then User should be logged out successfully
