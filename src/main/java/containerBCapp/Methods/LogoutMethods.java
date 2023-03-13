package containerBCapp.Methods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import containerBCapp.Baseclass.CommonUtilities;

public class LogoutMethods extends CommonUtilities {

	public void tapMoreButton() throws Throwable {

		tapTheElement("Settings", LocatorPropertiesFile);
	//	reportLog("Tapped on settings button");
		isDisplayed("Menu.MyBusiness", LocatorPropertiesFile);
	//	reportLog("MyBusiness button is displayed");

	}

	public void tapLogoutButton() throws Throwable {

	
		tapTheElement("Menu.LogOut", LocatorPropertiesFile);
	//	reportLog("Tapped on log out button");
		
		tapTheElement("Menu.YesLogOut", LocatorPropertiesFile);
		reportLog("Yes, log out is tapped");

	}

	public void validateLogout() throws Throwable {

		isDisplayed("Login.Email", LocatorPropertiesFile);
	//	reportLog("User logged out successfully");

	}
	
	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);

		boolean status = loginButton.isEnabled();
		System.err.println("disabed");
		System.err.println(status);
		Assert.assertEquals(status, false);
		reportLog("Login button is disabled");

	}
}
