package containerBCappStepDefinition;

import containerBCapp.Methods.LogoutMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoutStepdefiniton extends LogoutMethods {

	@Given("User taps on the settings button")
	public void user_taps_on_the_settings_button() throws Throwable {
		
		tapMoreButton();
	}

	@And("User tap on the logout button")
	public void user_tap_on_the_logout_button() throws Throwable {
		
		tapLogoutButton();
	}

	@Then("User should be logged out successfully")
	public void user_should_be_logged_out_successfully()  throws Throwable {
		
		validateLogout();
	}
	
	
//	@Given("The login button should be disabled with email and password field empty")
//    public void the_login_button_should_be_disabled_with_email_and_password_field_empty() throws Throwable {
//		
//		loginDisabled();
//	}

}
