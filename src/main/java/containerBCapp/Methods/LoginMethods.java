package containerBCapp.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import containerBCapp.ExcelRead.ExcelRead;

public class LoginMethods extends ExcelRead {

	public void loginDisabled() throws Throwable {

		WebElement loginButton = getMobileElement("loginxpath");
		boolean status = loginButton.isEnabled();
		Assert.assertEquals(status, false);
		PrintValue("Login button is disabled");

	}

	
//	public void enterInvalidCredentials() throws Throwable {
//		testData();
//		sendKey("Login.Email", inValidEmailID);
//		reportLog("Entered email: " + inValidEmailID);
//
//		sendKey("Login.Password", inValidpassword);
//		reportLog("Entered password: " + inValidpassword);
//	}

	public void loginErrorToast(String Text) throws Throwable {

		WebElement toastElement = IOsdriver.findElement(By.xpath(
				"//XCUIElementTypeStaticText[@name='"+Text+"']"));
		
//		WebElement toastElement = IOsdriver.findElement(By.xpath(
//				"//ios.widget.Toast"));

		String toastText = toastElement.getText();
		assertTextValue(toastText, Text);
	//	softTextPresent(toastText, Text);
		reportLog("Toast Message: " + toastText);
		PrintValue("Toast Message: " + toastText);
	}

	public void clearCredentials() throws Throwable {

//		clearData("AfterEmail");
//		clearData("AfterPassword");
		killAndRelaunch();
	}

//	public void enterTheCredentials() throws Throwable {
//		testData();
//		sendKey("Login.Email", validEmailID);
//		reportLog("Entered email: " + validEmailID);
//
//		sendKey("Login.Password", validpassword);
//		reportLog("Entered password: " + validpassword);
//
//	}
	
	public void enterTheCredentials(String Username, String Password) throws Throwable {
		
		sendKey("Login.Email", Username);
		reportLog("Entered email: " + Username);

		sendKey("Login.Password", Password);
		reportLog("Entered password: " + Password);

	}
	

	public void clickLoginButton() throws Throwable {

		tapTheElement("Login.LoginButton");

	}



	public void tapNextButton() throws Throwable {

		try {

			tapTheElement("Login.Next");
			tapTheElement("Login.Next");
			tapTheElement("Login.Next");
			tapTheElement("Login.Next");
			tapTheElement("Login.Getstarted");
		}catch (Exception e) {
			PrintValue("Not a first time login");
		}

	}

	public void tapSkipButton() throws Throwable {

		try {
			tapTheElement("Login.Skip");
		}
		catch (Exception e) {
			PrintValue("Not a first time login");
		}
	}

	public void validateLogin() throws Throwable {

		try{
			tapTheElement("Allow");
		}
		catch (Exception e){

		}

		isElementDisplayed("InboxHeader");
		PrintValue("Logged in successfully");

	}


}
