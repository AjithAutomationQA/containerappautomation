@Regression
Feature: To verify the chat in the connect tab

  Scenario: To verify UI elements in the chat conversation view
    Given User taps on the connect tab
    And User opens a chat
    Then The respective UI elements should be displayed

  Scenario: To verify send button is disabled when input bar is empty
    Given User taps on the connect tab
    And User opens a chat
    Then The send button should be disabled

  Scenario: To verify user cannot send empty message
    Given User taps on the connect tab
    And User opens a chat
    When User enters space in the input bar
    Then The send button should be disabled

  @test
  Scenario: To verify user can send message
    Given User taps on the connect tab
    And User opens a chat
    When User enters the message in the input bar
    Then The send button should be enabled
    When User taps on the send button
    Then The message should be sent successfully

    
