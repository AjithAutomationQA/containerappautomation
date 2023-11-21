@Regression
Feature: To verify the chat in the connect tab

#  @Connect
#  Scenario: To verify user can send message
#    Given User taps on the connect tab
#    And User opens a chat
#    When User enters the message in the input bar
#    Then The send button should be enabled
#    When User taps on the send button
#    Then The message should be sent successfully

  @Connect @Smoke
  Scenario: To verify UI elements in the chat conversation view
    Given User taps on the connect tab
    And User opens a chat
    Then The respective UI elements should be displayed

  @Connect @new
  Scenario: To verify reminder icon is shown in the recent chat list
    Given the active reminder icon should be shown in the recent list

  @Connect @new
  Scenario: To swipe and remove a message from the chat recent list
    Given user swipes the first chat from the chat list
    Then the chat should be removed from the list



  @Connect
  Scenario: To verify user can long press and perform actions from the bottom sheet

    Given User taps on the connect tab
    And User opens a chat
    And User enters the message in the input bar
    And The send button should be enabled
    When User taps on the send button

    And The user long press the recent message
    Then the bottom sheet should appear

    And The user long press the recent message
    When User taps on the pin button from the bottom sheet
    Then The message should be pinned successfully

    And The user long press the recent message
    When User taps on the unpin button from the bottom sheet
    Then The message should be unpinned successfully

    And The user long press the recent message
    When User taps on the edit button from the bottom sheet
    And User edits the message and tap on the save button
    Then The message should be edited successfully

    And The user long press the recent message
    When User taps on the copy and send the message
    Then The copied message should be sent successfully

    And The user long press the recent message
    When User taps on the delete button from the bottom sheet
    Then The message should be deleted successfully

  @Connect @Smoke
  Scenario: To verify send button is disabled when input bar is empty
    Given User taps on the connect tab
    And User opens a chat
    Then The send button should be disabled

  @Connect @Smoke
  Scenario: To verify user cannot send empty message
    Given User taps on the connect tab
    And User opens a chat
    When User enters space in the input bar
    Then The send button should be disabled


  @Connect
  Scenario:  To verify user can send a message successfully
    Given User taps on the connect tab
    And User opens a chat
    And User enters the message in the input bar
    And The send button should be enabled
    When User taps on the send button
    Then The message should be sent successfully

  @Connect
  Scenario:  To verify user can swipe and remove a chat from the list
    Given user swipe the first chat in the list
    Then the chat should be removed from the list

  @Connect
  Scenario: To verify user can send an image using useCamera option
    Given User taps on the connect tab
    And User opens a chat
    And User taps on the attachment icon
    And user taps on the useCamera button and click a photo
    And The send button should be enabled
    When User taps on the send button
    Then The attachment should be sent successfully


  @Connect
  Scenario: To verify user can send a file using FromFiles option
    Given User taps on the connect tab
    And User opens a chat
    And User taps on the attachment icon
    And user taps on the FromFiles button and select a attachment
    Then The attachment should be sent successfully



#
#  @Connect
#  Scenario: To verify user can long press and edit a message
#    Given User taps on the connect tab
#    And User opens a chat
#    And User enters the message in the input bar
#    And The send button should be enabled
#    When User taps on the send button
#    And The user long press the recent message
#    When User taps on the edit button from the bottom sheet
#    And User edits the message and tap on the save button
#    Then The message should be edited successfully


#  @Connect
#  Scenario: To verify user can long press and pin a message
#    Given User taps on the connect tab
#    And User opens a chat
#    And User enters the message in the input bar
#    And The send button should be enabled
#    When User taps on the send button
#    And The user long press the recent message
#    When User taps on the pin button from the bottom sheet
#    Then The message should be pinned successfully

#  @Connect1
#  Scenario: To verify user can long press and pin a message
#    Given User taps on the connect tab
#    And User opens a chat
#    And User enters the message in the input bar
#    And The send button should be enabled
#    When User taps on the send button
#    And The user long press the recent message
#    When User taps on the copy and send send the text
#    Then The message should be sent successfully
