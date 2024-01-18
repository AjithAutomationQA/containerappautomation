package containerBCappStepDefinition;

import containerBCapp.Methods.AddNoteMethods;
import containerBCapp.Methods.InboxMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNoteStepDefinition extends AddNoteMethods {

    @Given("taps on the addnote button")
    public void taps_on_the_addnote_button() throws Throwable {
        tapTheElement("Inbox.AddNote_button");
    }

    @Then("the send button should be disabled")
    public void the_send_button_should_be_disabled() throws Throwable {
        isElementDisabled("Inbox.SendDisabled");
    }

    @Given("enter value in the addnote")
    public void enter_value_in_the_addnote() throws Throwable {
        sendKey("Inbox.AddNote", "test note");
    }

    @When("taps on the send button")
    public void taps_on_the_send_button() throws Throwable {
        tapTheElement("Inbox.SendEnabled");
    }

    @Then("notes should be added successfully")
    public void notes_should_be_added_successfully() throws Throwable {
        toastMessage("Notes added successfully");
    }
    @Given("taps on the share button")
    public void taps_on_the_share_button() throws Throwable {
        tapTheElement("");
    }
    @Given("taps on the share through email button")
    public void taps_on_the_share_through_email_button() throws Throwable {
        tapTheElement("");
    }
    @Given("enter invalid email id")
    public void enter_invalid_email_id() throws Throwable {
       sendKey("","");
    }
    @When("tap on the send button")
    public void tap_on_the_send_button() throws Throwable {
       tapTheElement("");
    }
    @Then("the message shouldn't be shared")
    public void the_message_shouldn_t_be_shared() throws Throwable {
       toastMessage("");
    }

    @Given("enter valid email id")
    public void enter_valid_email_id()  throws Throwable {
       sendKey("","");
    }
    @Given("uncheck the include notes")
    public void uncheck_the_include_notes()  throws Throwable {
        tapTheElement("");
    }

    @Then("the message should be shared")
    public void the_message_should_be_shared()  throws Throwable {
       toastMessage("");
    }
}
