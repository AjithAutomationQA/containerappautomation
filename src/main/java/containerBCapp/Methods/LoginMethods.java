package containerBCapp.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import containerBCapp.ExcelRead.ExcelRead;

public class LoginMethods extends ExcelRead {

	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath", LocatorPropertiesFile);
		boolean status = loginButton.isEnabled();
		Assert.assertEquals(status, false);
		PrintValue("Login button is disabled");

	}

	
//	public void enterInvalidCredentials() throws Throwable {
//		testData();
//		sendKey("Login.Email", LocatorPropertiesFile, inValidEmailID);
//		reportLog("Entered email: " + inValidEmailID);
//
//		sendKey("Login.Password", LocatorPropertiesFile, inValidpassword);
//		reportLog("Entered password: " + inValidpassword);
//	}

	public void loginErrorToast(String Text) throws Throwable {

//		MobileElement toastElement = IOsdriver.findElement(By.xpath(
//				"//XCUIElementTypeStaticText[@name='Invalid credentials']"));
		
		WebElement toastElement = IOsdriver.findElement(By.xpath(
				"(//XCUIElementTypeStaticText)[5]"));

		String toastText = toastElement.getText();
	//	assertTextValue(toastText, Text);
		softTextPresent(toastText, Text);
		reportLog("Toast Message: " + toastText);
		PrintValue("Toast Message: " + toastText);
	}

	public void clearCredentials() throws Throwable {

//		clearData("AfterEmail", LocatorPropertiesFile);
//		clearData("AfterPassword", LocatorPropertiesFile);
		killAndRelaunch();
	}

//	public void enterTheCredentials() throws Throwable {
//		testData();
//		sendKey("Login.Email", LocatorPropertiesFile, validEmailID);
//		reportLog("Entered email: " + validEmailID);
//
//		sendKey("Login.Password", LocatorPropertiesFile, validpassword);
//		reportLog("Entered password: " + validpassword);
//
//	}
	
	public void enterTheCredentials(String Username, String Password) throws Throwable {
		
		sendKey("Login.Email", LocatorPropertiesFile, Username);
		reportLog("Entered email: " + Username);

		sendKey("Login.Password", LocatorPropertiesFile, Password);
		reportLog("Entered password: " + Password);

	}
	

	public void clickLoginButton() throws Throwable {

		tapTheElement("Login.LoginButton", LocatorPropertiesFile);

	}



	public void tapNextButton() throws Throwable {

		try {

			tapTheElement("Login.Next", LocatorPropertiesFile);
			tapTheElement("Login.Next", LocatorPropertiesFile);
			tapTheElement("Login.Next", LocatorPropertiesFile);
			tapTheElement("Login.Next", LocatorPropertiesFile);
			tapTheElement("Login.Getstarted", LocatorPropertiesFile);
		}catch (Exception e) {
			PrintValue("Not a first time login");
		}

	}

	public void tapSkipButton() throws Throwable {

		try {
			tapTheElement("Login.Skip", LocatorPropertiesFile);
		}
		catch (Exception e) {
			PrintValue("Not a first time login");
		}
	}

	public void validateLogin() throws Throwable {


		isElementDisplayed("ConnectHeader", LocatorPropertiesFile);
		PrintValue("Logged in successfully");

	}


}
