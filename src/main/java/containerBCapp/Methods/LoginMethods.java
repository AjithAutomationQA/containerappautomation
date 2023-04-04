package containerBCapp.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import containerBCapp.ExcelRead.ExcelRead;
import io.appium.java_client.MobileElement;

public class LoginMethods extends ExcelRead {

	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);
		boolean status = loginButton.isEnabled();
		Assert.assertEquals(status, false);
		PrintValue("Login button is disabled");

	}

	public void enterInvalidCredentials() throws Throwable {
		testData();
		sendKey("Login.Email", LocatorPropertiesFile, inValidEmailID);
		reportLog("Entered email: " + inValidEmailID);

		sendKey("Login.Password", LocatorPropertiesFile, inValidpassword);
		reportLog("Entered password: " + inValidpassword);
	}

	public void loginErrorToast(String Text) throws Throwable {

		try {

			MobileElement toastElement = IOsdriver.findElement(By.xpath(
					"//XCUIElementTypeStaticText[@name='Unable to verify your account. Please try login again.']"));

			String toastText = toastElement.getText();
			assertValues(toastText, Text);
			reportLog("Toast Message: " + toastText);
			PrintValue("Toast Message: " + toastText);
		} 
		catch (Exception e) {
			reportLog(e.getMessage());
		}
		finally {
			clearCredentials();
		}
	}
	
	public void clearCredentials() throws Throwable {

		clearData("AfterEmail", LocatorPropertiesFile);
		clearData("AfterPassword", LocatorPropertiesFile);
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

		isElementDisplayed("Inbound", LocatorPropertiesFile);
		PrintValue("Logged in successfully");

	}

}
