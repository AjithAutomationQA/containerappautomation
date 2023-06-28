package containerBCappStepDefinition;

import containerBCapp.Methods.LoginMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdefiniton extends LoginMethods {

	@Given("The login button should be disabled with email and password field are empty")
	public void the_login_button_should_be_disabled_with_email_and_password_field_are_empty() throws Throwable {

		loginDisabled();
	}

	@Given("User enters the invalid email and invalid password")
	public void user_enters_the_invalid_email_and_invalid_password() throws Throwable {

		enterInvalidCredentials();
	}

	@Then("User should see a warning toast")
	public void user_should_see_a_warning_toast() throws Throwable {

		loginErrorToast("Invalid credentials");
	}

	  @Given("User clears the email and password fields")
	    public void user_clears_the_email_and_password_fields() throws Throwable {

		  clearCredentials();
	  }
	  
	@And("User enters the valid email and valid password")
	public void user_enters_the_valid_email_and_valid_password() throws Throwable {

		enterTheCredentials();
	}

	@And("Taps on the login button")
	public void taps_on_the_login_button() throws Throwable {

		clickLoginButton();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() throws Throwable {

		validateLogin();
	}

	@And("Taps on the next button to get started")
	public void taps_on_the_next_button_to_get_started() throws Throwable {
		
		tapNextButton();
		
	}

	@And("Taps on the skip button to get started")
	public void taps_on_the_skip_button_to_get_started() throws Throwable {
		
		tapSkipButton();
		
	}
	
}
