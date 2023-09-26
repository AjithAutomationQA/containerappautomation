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

	@And("Enters the invalid email")
	public void enters_the_invalid_email() throws Throwable {

		enterInValidEmail();

	

	}
	
	@Then("A toast with a waring message should be displayed")
	public void a_toast_with_a_waring_message_should_be_displayed() throws Throwable {
	   
		ToastError("Invalid Email \n"
				+ "Please enter valid email.");
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

		ToastError("Reset link sent successfully");

	}

	@Given("^User taps on the back to login button$")
	public void user_taps_on_the_back_to_login_button() throws Throwable {
		tapBackToLoginButton();
	}

	@Then("^User should be land on the login page$")
	public void user_should_be_land_on_the_login_page() throws Throwable {
		loginTab();
	}

}
