package containerBCappStepDefinition;

import containerBCapp.Methods.LogoutMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoutStepdefiniton extends LogoutMethods {

	@Given("User taps on the settings button")
	public void user_taps_on_the_settings_button() throws Throwable {

		tapSettingsButton();
	}

	   @And("^User taps on the logout button$")
	    public void user_tap_on_the_logout_button()  throws Throwable {

		   tapLogoutButton();

	}
	   
	    @And("^taps cancel button$")
	    public void taps_cancel_button() throws Throwable {
	    	
	    	tapCancelButton();
	    }

	@Then("^User should stay in the settings tab$")
	public void user_should_stay_in_the_settings_tab() throws Throwable {

		settingsTab();
	}

	   @And("^taps yes logout button$")
	    public void taps_yes_logout_button() throws Throwable {

		   tapYesLogoutButton();
	}

	@Then("User should be logged out successfully")
	public void user_should_be_logged_out_successfully() throws Throwable {

		validateLogout();
	}

}
