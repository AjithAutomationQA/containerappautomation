package containerBCapp.Methods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import containerBCapp.Baseclass.DesiredCap;
import containerBCapp.ExcelRead.ExcelRead;

public class LoginMethods extends ExcelRead {

	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);
		boolean status = loginButton.isEnabled();
		Assert.assertEquals(status, false);
		reportLog("Login button is disabled");

	}

	public void enterInvalidCredentials() throws Throwable {
		sendKey("Login.Email", LocatorPropertiesFile, "testmail@gmail.com");
		reportLog("Entered email: " + "testmail@gmail.com");

		sendKey("Login.Password", LocatorPropertiesFile, "test13");
		reportLog("Entered password: " + "test13");
	}

	public void loginErrorToast() throws Throwable {

		try {
			waitForToast("Unable to verify your account. Please try login again.");
			clearData("AfterEmail", LocatorPropertiesFile);
			clearData("AfterPassword", LocatorPropertiesFile);
		} catch (Exception e) {
			clearData("AfterEmail", LocatorPropertiesFile);
			clearData("AfterPassword", LocatorPropertiesFile);
			reportLog(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public void enterTheCredentials() throws Throwable {

		testData();
		sendKey("Login.Email", LocatorPropertiesFile, validEmailID);
		reportLog("Entered email: " + validEmailID);
		sendKey("Login.Password", LocatorPropertiesFile, validpassword);
		reportLog("Entered password: " + validpassword);

	}

	public void clickLoginButton() throws Throwable {

		tapTheElement("Login.LoginButton", LocatorPropertiesFile);

	}

	public void validateLogin() throws Throwable {

		PrintError("waiting for Inbound");
		isDisplayed("Inbound", LocatorPropertiesFile);
		// reportLog("Inbound button is displayed");
		// reportLog("User logged in successfully");

	}

}
