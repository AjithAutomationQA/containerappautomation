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

}
