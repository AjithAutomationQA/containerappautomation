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
	}
	
	@Then("The message should be sent successfully")
	public void the_message_should_be_sent_successfully() throws Throwable {
		
		verify_SentMessage();
	}

}
