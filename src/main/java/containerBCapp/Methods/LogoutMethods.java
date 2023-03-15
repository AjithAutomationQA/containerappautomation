package containerBCapp.Methods;

import containerBCapp.Baseclass.CommonUtilities;

public class LogoutMethods extends CommonUtilities {

	public void tapMoreButton() throws Throwable {

		tapTheElement("Settings", LocatorPropertiesFile);
		isDisplayed("Menu.MyBusiness", LocatorPropertiesFile);

	}

	public void tapLogoutButton() throws Throwable {

	
		tapTheElement("Menu.LogOut", LocatorPropertiesFile);
		tapTheElement("Menu.YesLogOut", LocatorPropertiesFile);
		reportLog("Yes, log out is tapped");

	}

	public void validateLogout() throws Throwable {

		isDisplayed("Login.Email", LocatorPropertiesFile);
		PrintValue("User logged out successfully");

	}

}
