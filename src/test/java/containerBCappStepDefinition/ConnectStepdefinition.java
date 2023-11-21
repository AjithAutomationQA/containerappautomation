package containerBCappStepDefinition;

import containerBCapp.Methods.ConnectMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConnectStepdefinition extends ConnectMethods {



	@Given("User taps on the connect tab")
	public void user_taps_on_the_connect_tab() throws Throwable {

		tapOn_ConnectTab();

	}
	@And("User opens a chat")
	public void user_opens_a_chat() throws Throwable {

		tapOn_Chat();

	}
	
	@Then("The respective UI elements should be displayed")
	public void the_respective_ui_elements_should_be_displayed() throws Throwable {
		
		verify_ChatUI();
	}
	
	@When("User enters space in the input bar")
	public void user_enters_space_in_the_input_bar() throws Throwable {

		enter_EmptyMessage();
		
	}
	@Then("The send button should be disabled")
	public void the_send_button_should_be_disabled() throws Throwable {

		sendButton_Disabled();
	}
	
//////////////////////////////diabled done /////////////////////////////////////
	
	@When("User enters the message in the input bar")
	public void user_enters_the_message_in_the_input_bar() throws Throwable {
		
		enter_Message() ;
	}
	
	@Then("The send button should be enabled")
	public void the_send_button_should_be_enabled() throws Throwable {
		
		sendButton_Enabled();
	}
	
	@When("User taps on the send button")
	public void user_taps_on_the_send_button() throws Throwable {
		
		tap_SendButton();
		verify_ChatSentTime();
	}
	
	@Then("The message should be sent successfully")
	public void the_message_should_be_sent_successfully() throws Throwable {
		verifyMessgesent();

	}

	//////////////////////////////message verify done /////////////////////////////////////



	@Given("The user long press the recent message")
	public void the_user_long_press_the_recent_message() throws Throwable {

		longPressMessage();
	}
	@Then("the bottom sheet should appear")
	public void the_bottom_sheet_should_appear() throws Throwable {

		bottomSheet();
	}


	@When("User taps on the delete button from the bottom sheet")
	public void user_taps_on_the_delete_button_from_the_bottom_sheet() throws Throwable {
		tapOnTheDeleteButton();
	}

	@Then("The message should be deleted successfully")
	public void the_message_should_be_deleted_successfully() throws Throwable {
		verifyDeletedMessage();
	}

	//////////////////////////////message delete done /////////////////////////////////////
	@When("User taps on the edit button from the bottom sheet")
	public void user_taps_on_the_edit_button_from_the_bottom_sheet() throws Throwable {

		tapOnTheEditButton();
	}
	@When("User edits the message and tap on the save button")
	public void user_edits_the_message_and_tap_on_the_save_button() throws Throwable {

		editTheMessage();
	}

	@Then("The message should be edited successfully")
	public void the_message_should_be_edited_successfully() throws Throwable {

		verifyEditedMessage();
	}

	//////////////////////////////message edit done /////////////////////////////////////

	@When("User taps on the pin button from the bottom sheet")
	public void user_taps_on_the_pin_button_from_the_bottom_sheet() throws Throwable {
		pinTheMessage();
	}

	@Then("The message should be pinned successfully")
	public void the_message_should_be_pinned_successfully() throws Throwable {

		verifyPinnedMessage();
	}

	@When("User taps on the unpin button from the bottom sheet")
	public void user_taps_on_the_unpin_button_from_the_bottom_sheet()  throws Throwable {

		unPinTheMessage();
	}

	@Then("The message should be unpinned successfully")
	public void the_message_should_be_unpinned_successfully()  throws Throwable {
		verifyUnpinMessage();
	}

	@When("User taps on the copy and send the message")
	public void user_taps_on_the_copy_and_send_the_message() throws Throwable {

		copyAndPasteMessage();
	}

	@Then("The copied message should be sent successfully")
	public void the_copied_message_should_be_sent_successfully() throws Throwable {
		verifyCopyAndSendMessage();

	}

	//////////////////////////////message long press done /////////////////////////////////////
	@Given("User taps on the attachment icon")
	public void user_taps_on_the_attachment_icon() throws Throwable {

		tapAttachmentButton();
	}

	@And("user taps on the useCamera button and click a photo")
	public void user_taps_on_the_use_camera_button_and_click_a_photo() throws Throwable {

		clickPhoto();
	}

	@Then("The attachment should be sent successfully")
	public void the_attachment_should_be_sent_successfully() throws Throwable {
		verify_ChatSentTime();
		verify_ChatSentTick();
	}

	@Given("user taps on the FromFiles button and select a attachment")
	public void user_taps_on_the_from_files_button_and_select_a_attachment() throws Throwable {

		sendAttachments();
	}
//////////////////////////////message long press done /////////////////////////////////////

	@Given("user swipes the first chat from the chat list")
	public void user_swipes_the_first_chat_from_the_chat_list()  throws Throwable {
		//tapOn_Skip();
		tapOn_ConnectTab();
		readTheFirstChat();
		swipeTheChat();
	}
	@Then("the chat should be removed from the list")
	public void the_chat_should_be_removed_from_the_list() throws Throwable {

		verify_ChatName();
	}

	@Given("the active reminder icon should be shown in the recent list")
	public void the_active_reminder_icon_should_be_shown_in_the_recent_list() throws Throwable {
		tapOn_Skip();
		tapOn_ConnectTab();
		verify_ReminderInRecentChat();
	}

	}
