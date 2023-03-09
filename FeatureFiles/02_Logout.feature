Feature: To verify the logout feature

@Smoke
  Scenario: To logout the app
    Given User taps on the settings button
    And User tap on the logout button
    Then User should be logged out successfully


 #@Smoke 
  #Scenario: To verify that the login button is disabled
  #Given The login button should be disabled with email and password field empty

