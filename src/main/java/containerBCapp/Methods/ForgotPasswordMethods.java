package containerBCapp.Methods;

import org.openqa.selenium.By;
import org.testng.Assert;

import containerBCapp.ExcelRead.ExcelRead;
import io.appium.java_client.MobileElement;

public class ForgotPasswordMethods extends ExcelRead {

	public void tapForgotPassword() throws Throwable {

		tapTheElement("Forgot.Password", LocatorPropertiesFile);
		isDisplayed("Forgot.ResetPassword", LocatorPropertiesFile);

	}

	public void enterValidEmail() throws Throwable {
		testData();
		sendKey("Forgot.Email", LocatorPropertiesFile, inValidEmailID);
		reportLog("Entered email: " + inValidEmailID);

	}

	public void tapResetButton() throws Throwable {

		tapTheElement("Forgot.ResetPassword", LocatorPropertiesFile);

	}

	public void resetPasswordToast(String Text) throws Throwable {

		try {

			MobileElement toastElement = IOsdriver
					.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Reset link sent successfully']"));

			String toastText = toastElement.getText();
			Assert.assertEquals(toastText, Text);
			reportLog("Toast Message: " + toastText);
			PrintValue("Toast Message: " + toastText);

		} catch (Exception e) {
			reportLog(e.getMessage());
		} finally {

			clearData("Forgot.Email", LocatorPropertiesFile);
			tapTheElement("Forgot.BackToLogin", LocatorPropertiesFile);
			isDisplayed("Forgot.Password", LocatorPropertiesFile);

		}

	}

}
