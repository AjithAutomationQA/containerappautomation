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

	@Given("User enters the invalid email format and valid password")
	public void user_enters_the_invalid_email_format_and_valid_password()  throws Throwable {
		testData();
		enterTheCredentials(inValidEmailFormat, validpassword);

	}

	@Then("User should see a warning toast for invalid email format")
	public void user_should_see_a_warning_toast_for_invalid_email_format() throws Throwable {

		loginErrorToast("Invalid Email \n"
				+ "Please enter valid email.");
	}


	@Given("User enters the invalid email and valid password")
	public void user_enters_the_invalid_email_and_valid_password() throws Throwable {
		testData();
		enterTheCredentials(inValidEmailID, validpassword);

	}
	@Then("User should see a warning toast for invalid email")
	public void user_should_see_a_warning_toast_for_invalid_email() throws Throwable {

		loginErrorToast("Invalid credentials");

	}

	@Given("User enters the valid email and invalid password")
	public void user_enters_the_valid_email_and_invalid_password() throws Throwable {

		testData();
		enterTheCredentials(validEmailID, inValidpassword);

	}
	@Then("User should see a warning toast for invalid password")
	public void user_should_see_a_warning_toast_for_invalid_password() throws Throwable {

		loginErrorToast("Invalid credentials");
	}



	@Given("User enters the invalid email and invalid password")
	public void user_enters_the_invalid_email_and_invalid_password() throws Throwable {
		testData();
		enterTheCredentials(inValidEmailID,inValidpassword);
	}

	@Then("User should see a warning toast for invalid credentials")
	public void user_should_see_a_warning_toast_for_invalid_credentials() throws Throwable {

		loginErrorToast("Invalid credentials");
	}


	@Given("User clears the email and password fields")
	public void user_clears_the_email_and_password_fields() throws Throwable {

		clearCredentials();
	}



	@And("User enters the valid email and valid password")
	public void user_enters_the_valid_email_and_valid_password() throws Throwable {
		testData();
		enterTheCredentials(validEmailID,validpassword);
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
