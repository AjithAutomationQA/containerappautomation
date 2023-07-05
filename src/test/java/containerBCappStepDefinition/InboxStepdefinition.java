package containerBCappStepDefinition;

import org.testng.annotations.Test;

import containerBCapp.Methods.InboxMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InboxStepdefinition extends InboxMethods{



	@Given("User swipes the message to archive from the inbox")
	public void user_swipes_the_message_to_archive_from_the_inbox() throws Throwable {
		archiveSwipeByText();
		//archiveFirstreadMessage();
		//messagescript();
	}

	@And("User goes to archive tab")
	public void user_goes_to_archive_tab() throws Throwable {

		tapArchiveFromMenu();
	}

	@Then("User should find that messsage in the archive tab")
	public void user_should_find_that_messsage_in_the_archive_tab() throws Throwable {

		validateByTextInArchiveTab();
	}


	@Given("User longpress a message from the inbox")
	public void user_longpress_a_message_from_the_inbox() throws Throwable {

		longPressTheMessageByText();
	}


	@And("Taps on the archive button identifier")
	public void taps_on_the_archive_button_identifier() throws Throwable {

		tapTheArchiveButtonIdentifier();
	}

	////////////////////////////// Archive done /////////////////////////////////////



	@When("User swipes the message to unarchive from the archive tab")
	public void user_swipes_the_message_to_unarchive_from_the_archive_tab() throws Throwable {

		unArchiveSwipeByText();
	}

	@Then("User should find that messsage in the inbox tab")
	public void user_should_find_that_messsage_in_the_inbox_tab() throws Throwable {
		validateInboxTabByText();
	}

	////////////////////////////// Unarchive done /////////////////////////////////////	

	@And("Taps on the trash button identifier")
	public void taps_on_the_trash_button_identifier() throws Throwable {
		tapTheTrashButtonIdentifier();
	}

	@And("User goes to trash tab")
	public void user_goes_to_trash_tab() throws Throwable {
		tapTrashFromMenu();
	}

	@Then("User should find that messsage in the trash tab")
	public void user_should_find_that_messsage_in_the_trash_tab() throws Throwable {

		validateInTrashTabByText();
	}

	@When("User swipes the message to restore from the trash tab")
	public void user_swipes_the_message_to_restore_from_the_trash_tab() throws Throwable {

		restoreSwipeByText();
	}


	////////////////////////////// trash and restore done /////////////////////////////////////	

	@Given("User tries to select more than 6 no of messages in the inbox tab")
	public void user_tries_to_select_more_than_6_no_of_messages_in_the_inbox_tab() throws Throwable {
		selectMessages();
	}

	@Then("User should be allowed to select only 6 messages")
	public void user_should_be_allowed_to_select_only_6_messages() throws Throwable {
		validateNoOfSelectedMessage();
	}

	//////////////////////////////unread messages /////////////////////////////////////	

	@Given("User taps on the filter dropdown and selects unread")
	public void user_taps_on_the_filter_dropdown_and_selects_unread() throws Throwable {

		selectUnreadFromFilter();


	}
	@When("User taps on the applyFilter button")
	public void user_taps_on_the_apply_filter_button() throws Throwable {

		tapOnApplyButton();


	}
	@Then("Only unread messages should be displayed")
	public void only_unread_messages_should_be_displayed() throws Throwable {

		onlyUnreadMessageList();

	}

	////////////////////////////// compare unread messages /////////////////////////////////////	

	@Given("User verifies no of unread messages in inbox and unread filter are same")
	public void user_verifies_no_of_unread_messages_in_inbox_and_unread_filter_are_same() throws Throwable {

		compareInboxAndUnread();

	}

	//////////////////////////////all messages /////////////////////////////////////	

	@Given("User taps on the filter dropdown and selects all")
	public void user_taps_on_the_filter_dropdown_and_selects_all() throws Throwable {

		selectAllMessages();


	}
	@Then("All messages should be displayed")
	public void all_messages_should_be_displayed() throws Throwable {

	}

	////////////////////////////// mark as unread /////////////////////////////////////	


	@Given("User reads the first message")
	public void user_reads_the_first_message() throws Throwable {

		makeReadMessage() ;
	}
	@When("User longpress and unread the first message")
	public void user_longpress_and_unread_the_first_message()throws Throwable {

		makeUnreadMessage();

	}
	@Then("The message should be marked as unread")
	public void the_message_should_be_marked_as_unread() throws Throwable {
		assertMessageName();

	}

	@Then("The unread message should displayed")
	public void the_unread_message_should_displayed() throws Throwable {

		readMessageFromUnread();
	}
	//////////////////////////////mark as read /////////////////////////////////////	

	@When("User longpress and read the first message")
	public void user_longpress_and_read_the_first_message() throws Throwable {
		longPressAndReadMessage();

	}
	@Then("The message should move out from the unread list")
	public void the_message_should_move_out_from_the_unread_list()  throws Throwable {
		verifyUnreadList();
	}

	//////////////////////////////mark as read archive /////////////////////////////////////
	@When("User swipes the first message to archive from the inbox")
	public void user_swipes_the_first_message_to_archive_from_the_inbox() throws Throwable {

		archiveFirstUnreadMessage();

	}

	@Then("The archived message should not be displayed in the unread filter")
	public void the_archived_message_should_not_be_displayed_in_the_unread_filter() throws Throwable {
		archivenotinUnread();
	}

	//////////////////////////////mark as read trash /////////////////////////////////////
	@Given("User longpress and send the message to the trash")
	public void user_longpress_and_send_the_message_to_the_trash() throws Throwable {
		longPressAndTrash();

	}

	@Then("The trashed message should not be displayed in the unread filter")
	public void the_trashed_message_should_not_be_displayed_in_the_unread_filter() throws Throwable {
		trashednotinUnread();
	}
}
