@Logout
Feature: To verify the logout feature

  @Smoke
  Scenario: To cancel the logout
    Given User taps on the settings button
    And User tap on the logout button and taps cancel button
    Then User should stay in the settings tab

  @Smoke
  Scenario: To logout the app
    And User tap on the logout button and taps logout button
    Then User should be logged out successfully
