package containerBCapp.Methods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import containerBCapp.Baseclass.DesiredCap;
import containerBCapp.ExcelRead.ExcelRead;

public class LoginMethods extends ExcelRead {


	public void enterTheCredentials() throws Throwable {

		testData();
		WebElement email = getMobileElement("Login.Email", LocatorPropertiesFile);
		sendKey(email, validEmailID);
		ExtentCucumberAdapter.addTestStepLog("Entered email: " + validEmailID);

		WebElement password = getMobileElement("Login.Password", LocatorPropertiesFile);
		sendKey(password, validpassword);
		ExtentCucumberAdapter.addTestStepLog("Entered password: " + validpassword);

	}

	public void clickLoginButton() throws Throwable {

		WebElement loginButton = getMobileElement("Login.LoginButton", LocatorPropertiesFile);

		tapTheElement(loginButton);

	}

	public void validateLogin() throws Throwable {

		PrintError("waiting for Inbound");
		WebElement Inbound = getMobileElement("Inbound", LocatorPropertiesFile);
		isDisplayed(Inbound);

		// ExtentCucumberAdapter.addTestStepLog("Inbound button is displayed");
		// ExtentCucumberAdapter.addTestStepLog("User logged in successfully");

	}

	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);

		boolean status = loginButton.isEnabled();
		Assert.assertEquals(status, false);
		ExtentCucumberAdapter.addTestStepLog("Login button is disabled");

	}
	
	public void enterInvalidCredentials() throws Throwable {

		WebElement email = getMobileElement("Login.Email", LocatorPropertiesFile);
		sendKey(email, "testmail@gmail.com");
		ExtentCucumberAdapter.addTestStepLog("Entered email: " + "testmail@gmail.com");

		WebElement password = getMobileElement("Login.Password", LocatorPropertiesFile);
		sendKey(password, "test13");
		ExtentCucumberAdapter.addTestStepLog("Entered password: " + "test13");
		

		
	}
}
