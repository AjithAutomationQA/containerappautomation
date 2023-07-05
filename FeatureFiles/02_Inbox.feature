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

 

  #@Inbox
  #Scenario: To longpress and select 6 messages
    #Given User tries to select more than 6 no of messages in the inbox tab
    #Then User should be allowed to select only 6 messages
