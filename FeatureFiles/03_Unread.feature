@Regression
Feature: To verify the unread feature in inbox

  @unread 
  Scenario: To filter the unread messages
    Given User taps on the filter dropdown and selects unread
    When User taps on the applyFilter button
    Then Only unread messages should be displayed

  @unread
  Scenario: To verify no of unread messages in inbox and unread filter are same
    Given User verifies no of unread messages in inbox and unread filter are same

  #Scenario: To select all message from filter
    #Given User taps on the filter dropdown and selects all
    #When User taps on the applyFilter button
    #Then All messages should be displayed

  @unread
  Scenario: To verify user can mark a message as unread and checks the same in unread filter
    Given User reads the first message
    When User longpress and unread the first message
    Then The message should be marked as unread
    And User taps on the filter dropdown and selects unread
    When User taps on the applyFilter button
    Then The unread message should displayed

  @unread
  Scenario: To verify user can mark a message as read in unread filter
    Given User taps on the filter dropdown and selects unread
    And User taps on the applyFilter button
    When User longpress and read the first message
    Then The message should move out from the unread list

  @unread
  Scenario: To verify unread archived message is not displayed in unread filter
    Given User reads the first message
    When User longpress and unread the first message
    And User swipes the first message to archive from the inbox
    And User taps on the filter dropdown and selects unread
    And User taps on the applyFilter button
    Then The archived message should not be displayed in the unread filter

  @unread
  Scenario: To verify unread trashed message is not displayed in unread filter
    Given User reads the first message
    When User longpress and unread the first message
    Given User longpress and send the message to the trash
    And User taps on the filter dropdown and selects unread
    And User taps on the applyFilter button
    Then The trashed message should not be displayed in the unread filter
