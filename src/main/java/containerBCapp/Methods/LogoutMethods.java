package containerBCapp.Methods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import containerBCapp.Baseclass.CommonUtilities;

public class LogoutMethods extends CommonUtilities {

	public void tapMoreButton() throws Throwable {

		WebElement Settings = getMobileElement("Settings", LocatorPropertiesFile);
		tapTheElement(Settings);
	//	ExtentCucumberAdapter.addTestStepLog("Tapped on settings button");
		WebElement myBusiness = getMobileElement("Menu.MyBusiness", LocatorPropertiesFile);
		isDisplayed(myBusiness);
	//	ExtentCucumberAdapter.addTestStepLog("MyBusiness button is displayed");

	}

	public void tapLogoutButton() throws Throwable {

	
		WebElement logoutButton = getMobileElement("Menu.LogOut", LocatorPropertiesFile);
		tapTheElement(logoutButton);
	//	ExtentCucumberAdapter.addTestStepLog("Tapped on log out button");
		
		WebElement yesLogoutButton = getMobileElement("Menu.YesLogOut", LocatorPropertiesFile);
		tapTheElement(yesLogoutButton);
		ExtentCucumberAdapter.addTestStepLog("Yes, log out is tapped");

	}

	public void validateLogout() throws Throwable {

		WebElement emailField = getMobileElement("Login.Email", LocatorPropertiesFile);
		isDisplayed(emailField);
	//	ExtentCucumberAdapter.addTestStepLog("User logged out successfully");

	}
	
	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);

		boolean status = loginButton.isEnabled();
		System.err.println("disabed");
		System.err.println(status);
		Assert.assertEquals(status, false);
		ExtentCucumberAdapter.addTestStepLog("Login button is disabled");

	}
}
