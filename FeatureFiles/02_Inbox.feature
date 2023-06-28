@Regression
Feature: To verify the inbox feature

  @Inbox
  Scenario: To swipe and archive a message from inbox
    Given User swipes the message to archive from the inbox
    And User goes to archive tab
    Then User should find that messsage in the archive tab

  @Inbox
  Scenario: To longpress and archive a message from inbox
    Given User longpress a message from the inbox
    And Taps on the archive button identifier
    And User goes to archive tab
    Then User should find that messsage in the archive tab

  @Inbox
  Scenario: To swipe and unarchive a message from archive tab
    Given User goes to archive tab
    When User swipes the message to unarchive from the archive tab
    Then User should find that messsage in the inbox tab

  @Inbox
  Scenario: To longpress and trash a message from inbox
    Given User longpress a message from the inbox
    And Taps on the trash button identifier
    And User goes to trash tab
    Then User should find that messsage in the trash tab

  @Inbox
  Scenario: To swipe and restore a message from trash tab
    Given User goes to trash tab
    When User swipes the message to restore from the trash tab
    Then User should find that messsage in the inbox tab

  @unread @test
  Scenario: To filter the unread messages
    Given User taps on the filter dropdown and selects unread
    When User taps on the applyFilter button
    Then Only unread messages should be displayed

  @unread @test
  Scenario: To verify no of unread messages in inbox and unread filter are same
    Given User verifies no of unread messages in inbox and unread filter are same

  @unread 
  Scenario: To select all message from filter
    Given User taps on the filter dropdown and selects all
    When User taps on the applyFilter button
    Then All messages should be displayed

  @unread @test
  Scenario: To verify user can mark a message as unread and checks the same in unread filter
    Given User reads the first message
    When User longpress and unread the first message
    Then The message should be marked as unread
    And User taps on the filter dropdown and selects unread
    When User taps on the applyFilter button
    Then The unread message should displayed

  @unread @test
  Scenario: To verify user can mark a message as read in unread filter
    Given User taps on the filter dropdown and selects unread
    And User taps on the applyFilter button
    When User longpress and read the first message
    Then The message should move out from the unread list

  @unread @test
  Scenario: To verify unread archived message is not displayed in unread filter
    Given User reads the first message
    When User longpress and unread the first message
    And User swipes the first message to archive from the inbox
    And User taps on the filter dropdown and selects unread
    And User taps on the applyFilter button
    Then The message should not be displayed in the unread filter

  #And The same message should be marked as read in the inboxtab
  #@Inbox
  Scenario: To longpress and select 6 messages
    Given User tries to select more than 6 no of messages in the inbox tab
    Then User should be allowed to select only 6 messages
