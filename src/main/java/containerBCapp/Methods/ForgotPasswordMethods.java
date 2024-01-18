package containerBCapp.Methods;

import org.openqa.selenium.By;

import containerBCapp.ExcelRead.ExcelRead;
import org.openqa.selenium.WebElement;

public class ForgotPasswordMethods extends ExcelRead {

	public void tapForgotPassword() throws Throwable {

		tapTheElement("Forgot.Password");
		isElementDisplayed("Forgot.ResetPassword");

	}
	
	public void enterInValidEmail() throws Throwable {
		testData();
		sendKey("Forgot.Email", inValidEmailFormat);
		reportLog("Entered invalid email: " + inValidEmailFormat);

	}

	public void enterValidEmail() throws Throwable {
		testData();
		sendKey("Forgot.Email", validEmailID);
		reportLog("Entered email: " + validEmailID);

	}

	public void tapResetButton() throws Throwable {

		tapTheElement("Forgot.ResetPassword");

	}

//	public void resetPasswordToast(String Text) throws Throwable {
//
//		try {
//
//			MobileElement toastElement = IOsdriver
//					.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Reset link sent successfully']"));
//
//			String toastText = toastElement.getText();
//			assertTextValue(toastText, Text);
//			reportLog("Toast Message: " + toastText);
//			PrintValue("Toast Message: " + toastText);
//
//		} catch (Exception e) {
//			reportLog(e.getMessage());
//		}
//
//	}
	
	public void tapBackToLoginButton() throws Throwable {
		clearData("Forgot.Email");
		tapTheElement("Forgot.BackToLogin");
		
		
	}
	
	public void ToastError(String Text) throws Throwable {


		WebElement toastElement = IOsdriver.findElement(By.xpath(
				"(//XCUIElementTypeStaticText)[2]"));
		
		String toastText = toastElement.getText();
		assertTextValue(toastText, Text);
		reportLog("Toast Message: " + toastText);
		PrintValue("Toast Message: " + toastText);
	}
	
	public void loginTab()  throws Throwable {
		isElementDisplayed("Forgot.Password");
	}

}
