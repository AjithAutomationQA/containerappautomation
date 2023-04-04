package containerBCapp.Methods;

import containerBCapp.Baseclass.CommonUtilities;

public class LogoutMethods extends CommonUtilities {

	public void tapSettingsButton() throws Throwable {

		tapTheElement("Settings", LocatorPropertiesFile);
		isElementDisplayed("Menu.MyBusiness", LocatorPropertiesFile);

	}

	public void tapCancelButton() throws Throwable {
		tapTheElement("Menu.LogOut", LocatorPropertiesFile);
		tapTheElement("Menu.Cancel", LocatorPropertiesFile);

	}

	public void settingsTab() throws Throwable {

		isElementDisplayed("Menu.MyBusiness", LocatorPropertiesFile);

	}

	public void tapLogoutButton() throws Throwable {

		tapTheElement("Menu.LogOut", LocatorPropertiesFile);
		tapTheElement("Menu.YesLogOut", LocatorPropertiesFile);

	}

	public void validateLogout() throws Throwable {

		isElementDisplayed("Login.Email", LocatorPropertiesFile);
		PrintValue("User logged out successfully");

	}

}
