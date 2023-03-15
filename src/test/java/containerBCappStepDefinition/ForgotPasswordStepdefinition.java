package containerBCappStepDefinition;

import containerBCapp.Methods.ForgotPasswordMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ForgotPasswordStepdefinition extends ForgotPasswordMethods {

	@Given("User taps on the forgot password button")
	public void user_taps_on_the_forgot_password_button() throws Throwable {
		tapForgotPassword();
	}

	@And("Enters the valid email")
	public void enters_the_valid_email() throws Throwable {
		enterValidEmail();
	}

	@And("Taps on the reset password button")
	public void taps_on_the_reset_password_button() throws Throwable {
		tapResetButton();
	}

	@Then("Reset link should be sent successfully")
	public void reset_link_should_be_sent_successfully() throws Throwable {
		resetPasswordToast("Reset link sent successfully");
		
	}

}
