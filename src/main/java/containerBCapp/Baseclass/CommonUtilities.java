package containerBCapp.Baseclass;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.cucumber.java.Scenario;

public class CommonUtilities {

	public static Properties Prop;
	public static String Locator;
	public static File FileLocation;
	public static IOSDriver<IOSElement> IOsdriver;

	public static String LocatorPropertiesFile = "./src/test/resources/Properties/Xpath.properties";
	public static String AppPropertiesFile = "./src/test/resources/Properties/App.properties";
	public static String ExcelFile = "./TestData/AnswerConnectData.xlsx";

	@SuppressWarnings("static-access")
	public static void lauchTheApp() throws Throwable {

		DesiredCap dc = new DesiredCap();
		dc.LaunchIosApp();

	}

	public static String ReadProperties(String Property, String Location) throws Throwable {

		Prop = new Properties();
		File FileLocation = new File(Location);
		FileReader ReadFile = new FileReader(FileLocation);
		Prop.load(ReadFile);
		return Prop.getProperty(Property);
	}

	public WebElement getElement(String Property, String Location) throws Throwable {

		String LocatorType, LocatorValue;
		Properties Prop = new Properties();
		FileLocation = new File(Location);
		FileReader File = new FileReader(FileLocation);
		Prop.load(File);
		LocatorType = Prop.getProperty(Property).split(":")[0];
		LocatorValue = Prop.getProperty(Property).split(":")[1];

		if (LocatorType.toLowerCase().equals("accessibility"))
			return (WebElement) IOsdriver.findElement(MobileBy.AccessibilityId(LocatorValue));
		else if (LocatorType.toLowerCase().equals("xpath"))
			return IOsdriver.findElementByXPath(LocatorValue);

		else
			throw new Exception("Unknown locator type '" + LocatorType + "'");

	}

	public void waitForTheElement(String Locator, String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(IOsdriver, 60);
		WebElement element = getElement(Locator, locatorfile);

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement getMobileElement(String Locator, String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(IOsdriver, 60);
		WebElement element = getElement(Locator, locatorfile);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}

	public WebElement isElementDisplayed(String Locator, String locatorfile) throws Throwable {

		WebElement element = getMobileElement(Locator, locatorfile);
		Assert.assertEquals(true, element.isDisplayed());
		return element;
	}

	public void tapTheElement(String Locator, String locatorfile) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.click();
	}

	public void sendKey(String Locator, String locatorfile, String name) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.sendKeys(name);
	}

	public void clearData(String Locator, String locatorfile) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.clear();
	}

	public void assertValues(String toastText, String Text) throws Throwable {

		Assert.assertEquals(toastText, Text);
	}

	public void reportLog(String Log) {

		ExtentCucumberAdapter.addTestStepLog(Log);
	}

	public void PrintValue(String Value) {

		System.out.println(Value);
	}

	public void PrintError(String Value) {

		System.err.println(Value);
	}

	public void ScrollToElement(String Xpath, String Direction) {

		JavascriptExecutor js = (JavascriptExecutor) IOsdriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", Direction);
		scrollObject.put("xpath", Xpath);
		js.executeScript("mobile: scroll", scrollObject);

	}

	public void findElementByText(String text) {

		try {
			WebElement locator = IOsdriver
					.findElement(MobileBy.iOSClassChain(("**/XCUIElementTypeTextField[`value == \"" + text + "\"`]")));

			System.out.println(locator);
			locator.clear();
		} catch (Exception e) {
			System.out.println("cleared");
		}
	}

	@SuppressWarnings("null")
	public void screenShot() throws Throwable {
		Scenario scenario = null;
		final byte[] screenshot = IOsdriver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "");

	}

}
