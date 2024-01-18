package containerBCapp.Methods;

import containerBCapp.Baseclass.CommonUtilities;

public class LogoutMethods extends CommonUtilities {

	public void tapSettingsButton() throws Throwable {

		tapTheElement("Settings");
		isElementDisplayed("Menu.MyBusiness");

	}

	public void tapLogoutButton() throws Throwable {
		tapTheElement("Menu.LogOut");

	}
	
	public void tapCancelButton() throws Throwable {
		tapTheElement("Menu.Cancel");

	}

	public void settingsTab() throws Throwable {

		isElementDisplayed("Menu.MyBusiness");

	}

	public void tapYesLogoutButton() throws Throwable {

		tapTheElement("Menu.LogOut");
		tapTheElement("Menu.YesLogOut");

	}

	public void validateLogout() throws Throwable {

		isElementDisplayed("Login.Email");
		PrintValue("User logged out successfully");

	}

}
