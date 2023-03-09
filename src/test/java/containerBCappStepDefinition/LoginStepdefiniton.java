package containerBCappStepDefinition;

import org.openqa.selenium.WebElement;

import containerBCapp.Methods.LoginMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepdefiniton extends LoginMethods {

	@Given("User opens the app")
	public void user_opens_the_app() throws Throwable {

		lauchTheApp();
	}

	@And("Enters the valid email and valid password")
	public void enters_the_valid_email_and_valid_password() throws Throwable {

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

	@Given("The login button should be disabled with email and password field empty")
	public void the_login_button_should_be_disabled_with_email_and_password_field_empty() throws Throwable {

		loginDisabled();
	}

	@And("Enters the invalid email and invalid password")
	public void enters_the_invalid_email_and_invalid_password() throws Throwable {

		enterInvalidCredentials();
	}

	@Then("User should see a warning toast")
	public void user_should_see_a_warning_toast() throws Throwable {
		
		
		waitForToast("Unable to verify your account. Please try login again.");
		WebElement afteremail = getMobileElement("AfterEmail", LocatorPropertiesFile);
		afteremail.clear();
		WebElement afterpassword = getMobileElement("AfterPassword", LocatorPropertiesFile);
		afterpassword.clear();
	
	}

}
