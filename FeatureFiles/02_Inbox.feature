@Regression
Feature: To verify the inbox feature

  @Inbox @Smoke
  Scenario: To verify user can tap and view the message details
    Given User taps on a message
    Then User should see the message detailed view

  @Inbox
  Scenario: To swipe and archive a message from inbox
    Given User swipes the message to archive from the inbox
    And User goes to archive tab
    Then User should find that message in the archive tab

  @Inbox
  Scenario: To longpress and archive a message from inbox
    Given User longpress a message from the inbox
    And Taps on the archive button identifier
    And User goes to archive tab
    Then User should find that message in the archive tab

  @Inbox @Smoke
  Scenario: To verify user can archive a message from the bottom sheet
    Given User taps on a message
    And Tap on the dropdown button
    And Tap on the archive button from the bottom sheet
    Then The message should be sent to archive tab
#    And User goes to archive tab
#    Then User should find that message in the archive tab

  @Inbox
  Scenario: To swipe and unarchive a message from archive tab
    Given User goes to archive tab
    When User swipes the message to unarchive from the archive tab
    Then User should find that message in the inbox tab

  @Inbox
  Scenario: To longpress and trash a message from inbox
    Given User longpress a message from the inbox
    And Taps on the trash button identifier
    And User goes to trash tab
    Then User should find that messsage in the trash tab

  @Inbox @Smoke
  Scenario: To verify user can trash a message from the bottom sheet
    Given User taps on a message
    And Tap on the dropdown button
    And Tap on the trash button from the bottom sheet
    Then The message should be sent to trash tab
#    And User goes to trash tab
#    Then User should find that message in the trash tab

  @Inbox
  Scenario: To swipe and restore a message from trash tab
    Given User goes to trash tab
    When User swipes the message to restore from the trash tab
    Then User should find that message in the inbox tab

  #@Inbox 
  #Scenario: To verify that user can send a feedback to a message
    #Given User taps on a message
    #And Tap on the dropdown button
    #And Tap on the feedback button from the bottom sheet
    #And Enters the feedback in the input field
    #When Taps on the send button
    #Then The feedback should be sent successfully
    #And Tap on the dropdown button
    #Then The feedback should not be visible

  @Inbox
  Scenario: To verify user can longpress and select only 5 messages
    Given User tries to select more than 5 no of messages in the inbox tab
    Then User should be allowed to select only 5 messages
