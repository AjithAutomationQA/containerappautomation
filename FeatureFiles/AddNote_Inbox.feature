@Regression
Feature: To verify add note feature

  @addNote
  Scenario: To verify send button is disabled when no notes are entered
    Given User taps on a message
    And taps on the addnote button
    Then the send button should be disabled

  @addNote
  Scenario: To verify the user can add a note with texts and emojis
    Given User taps on a message
    And taps on the addnote button
    And enter value in the addnote
    When taps on the send button
    Then notes should be added successfully

  @addNote
  Scenario: To verify the user is unable to send email to an invalid address
    Given User taps on a message
    And taps on the share button
    And taps on the share through email button
    And enter invalid email id
    When tap on the send button
    Then the message shouldn't be shared

  @addNote
  Scenario: To verify the user can forward an email without include notes
    Given User taps on a message
    And taps on the share button
    And taps on the share through email button
    And enter valid email id
    And uncheck the include notes
    When tap on the send button
    Then the message should be shared

  @addNote
  Scenario: To verify the user can forward an email with notes
    Given User taps on a message
    And taps on the share button
    And taps on the share through email button
    And enter valid email id
    When tap on the send button
    Then the message should be shared