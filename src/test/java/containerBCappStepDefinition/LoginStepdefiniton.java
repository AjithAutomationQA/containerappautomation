package containerBCappStepDefinition;

import containerBCapp.Methods.LoginMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdefiniton extends LoginMethods {

//	@Given("User opens the app")
//	public void user_opens_the_app() throws Throwable {
//
//		
//	}
	
	@And("The login button should be disabled with email and password field empty")
	public void the_login_button_should_be_disabled_with_email_and_password_field_empty() throws Throwable {

		loginDisabled();
	}

	@Given("User enters the invalid email and invalid password")
	public void user_enters_the_invalid_email_and_invalid_password() throws Throwable {

		enterInvalidCredentials();
	}

	@Then("User should see a warning toast")
	public void user_should_see_a_warning_toast() throws Throwable {

		loginErrorToast();

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

}
