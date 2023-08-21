package containerBCapp.Baseclass;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtilities {

	public static AppiumDriverLocalService service;
	public static Properties Prop;
	public static String Locator;
	public static File FileLocation;
	public static IOSDriver IOsdriver;
	public static SoftAssert sa;

	public static String LocatorPropertiesFile = "./src/test/resources/Properties/Xpath.properties";
	public static String AppPropertiesFile = "./src/test/resources/Properties/App.properties";
	public static String ExcelFile = "./TestData/AnswerConnectData.xlsx";


	public static AppiumDriverLocalService startServer(){
		boolean flag = checkIfServerRunning(4723);
		if(!flag){
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder
					.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
					.usingDriverExecutable(new File("/usr/local/bin/node"))
					.usingPort(4723)
					.withArgument(GeneralServerFlag.USE_PLUGINS, "element-wait@2.0.3")
					.withLogFile(new File("test-output/AppiumLogs/"+"AppiumLog.txt"));
			service =  AppiumDriverLocalService.buildService(builder);
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerRunning(int portNumber){
		boolean isServerRunning=false;
		ServerSocket serversocket;
		try{
			serversocket = new ServerSocket(portNumber);
			serversocket.close();
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		return isServerRunning;
	}

	@SuppressWarnings("static-access")
	public static void lauchTheApp() throws Throwable {

		Capabilities capabilities = new Capabilities();
		service = startServer();
		capabilities.LaunchIosApp();

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
		WebDriverWait wait = new WebDriverWait(IOsdriver,Duration.ofSeconds(30));
		LocatorType = Prop.getProperty(Property).split(":")[0];
		LocatorValue = Prop.getProperty(Property).split(":")[1];

		switch (LocatorType.toLowerCase()) {
			case "accessibility":
//				wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(LocatorValue)));
				return IOsdriver.findElement(AppiumBy.accessibilityId(LocatorValue));

			case "xpath":
//				wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(LocatorValue)));
				return IOsdriver.findElement(AppiumBy.xpath(LocatorValue));

			case "iosclasschain":
//				wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain(LocatorValue)));
				return IOsdriver.findElement(AppiumBy.iOSClassChain(LocatorValue));

			default:
				throw new Exception("Unknown locator type '" + LocatorType + "'");
		}


	}

//	public void waitFor(WebElement element) throws Throwable {
//
//		WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(60));
//
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//
//	}

//	public void waitForTheElement(String Locator, String locatorfile) throws Throwable {
//
//		WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(60));
//		WebElement element = getElement(Locator, locatorfile);
//
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//
//	}

	public WebElement getMobileElement(String Locator, String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(60));
		WebElement element = getElement(Locator, locatorfile);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.isDisplayed();
		return element;

	}

	public WebElement isElementDisplayed(String Locator, String locatorfile) throws Throwable {

		WebElement element = getMobileElement(Locator, locatorfile);
		Assert.assertEquals(true, element.isDisplayed());
		return element;
	}


	public WebElement isElementDisplayed(WebElement element) throws Throwable {

		Assert.assertEquals(true, element.isDisplayed());
		return element;
	}

	public WebElement tapTheElement(String Locator, String locatorfile) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.click();
		return element;
	}

	public void sendKey(String Locator, String locatorfile, String name) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.click();
		element.sendKeys(name);
	}

	public void clearData(String Locator, String locatorfile) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		element.click();
		element.clear();
	}

	public String getText(String Locator, String locatorfile) throws Throwable {
		WebElement element = getMobileElement(Locator, locatorfile);
		String text = element.getText();
		return text;
	}

	public void assertTextValue(String toastText, String Text) throws Throwable {

		Assert.assertEquals(toastText, Text);
	}

	public void assertTextFalse(String toastText, String Text) throws Throwable {

		Assert.assertEquals(false, toastText.equalsIgnoreCase(Text) );
	}

	public void assertEquals(WebElement element, String input, String name) {
		
		String getheadertext = element.getText();
		Assert.assertEquals(input, getheadertext);
		PrintValue(name);
	}

	public void isSoftElementDisplayed(WebElement element, String input, String name){
		
		SoftAssert sa = new SoftAssert();
		String getheadertext = element.getText();
		sa.assertEquals(input, getheadertext);
	//	sa.assertAll();
		reportLog("Actual element :- ");
	}
	
	public void softTextPresent(String toastText, String Text){
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(toastText, Text);
		//sa.assertAll();
		reportLog("Actual element :- ");
		
	}

	public void reportLog(String Log) {
		System.out.println("Log" + Log);
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

	public WebElement findElementByName(String Name) {
		WebElement	locator = IOsdriver.findElement(MobileBy.iOSClassChain(("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]")));

		return locator;
	}


	public String swipeRightToLeft(String Name, String Direction) throws Throwable {

		String flag = "False";
		String messageName = null;
		WebElement element = null;
		PrintValue("Looking for the given message");
		while (flag == "False") {

			System.out.println("NAME IS = "+ Name);
			element = ioschain("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]");
			if(element.isDisplayed()) {
				messageName = element.getText();
				int leftX = element.getLocation().getX();
				int rightX = leftX + element.getSize().getWidth();
				int upperY = element.getLocation().getY();
				TouchAction action = new TouchAction(IOsdriver);
				action.press(PointOption.point(rightX, upperY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(0, upperY))
				.release();
				IOsdriver.performTouchAction(action);
				flag = "false";
			}
			else {
				PrintValue("Scrolling to the given element");
				HashMap<String, Object> scrollObject = new HashMap<String, Object>();
				scrollObject.put("direction", Direction);
				scrollObject.put("xpath", element);
				IOsdriver.executeScript("mobile: scroll", scrollObject);
			}

		}
		return messageName;

	}

	public String swipeR2LusingLocator(WebElement Element) throws Throwable {
		String text = null;
		if(Element.isDisplayed()) {
			text	 = Element.getText();
			PrintValue(text);
			int leftX = Element.getLocation().getX();
			int rightX = leftX + Element.getSize().getWidth();
			int upperY = Element.getLocation().getY();
			TouchAction action = new TouchAction(IOsdriver);
			action.press(PointOption.point(rightX, upperY))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(0, upperY))
			.release();
			IOsdriver.performTouchAction(action);
		}
		return text;


	}

	public WebElement ioschain(String inboxMessage) {

		WebElement d = IOsdriver.findElement(AppiumBy.iOSClassChain(inboxMessage));
		return d;
	}

	public WebElement scroll(String Name, String Direction) throws Throwable {

		String flag = "False";
		WebElement element = null;

		while (flag == "False") {

			element = ioschain("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]");
			if (element.isDisplayed()) {
				PrintValue("Message found");
//				waitFor(element);
				flag = "false";
			}


			else {
				PrintValue("Scrolling to the given element");
				HashMap<String, Object> scrollObject = new HashMap<String, Object>();
				scrollObject.put("direction", Direction);
				scrollObject.put("xpath", element);
				IOsdriver.executeScript("mobile: scroll", scrollObject);
			}

		}
		return element;
	}

	public String longPress(String Name, String Direction) {

		// Find the current element
		//		WebElement currentElement = IOsdriver.findElement(By.xpath("//your_current_locator"));
		//
		//		// Find the preceding sibling element
		//		MobileElement precedingElement = null;
		//		List<IOSElement> precedingElements = IOsdriver.findElements(By.xpath("//preceding-sibling::*"));
		//		for (MobileElement element : precedingElements) {
		//			if (element.getLocation().getY() < currentElement.getLocation().getY()) {
		//				precedingElement = element;
		//			}
		//		}


		String flag = "False";
		String messageName = null;
		WebElement element = null;
		PrintValue("Looking for the given message to long press");
		while (flag == "False") {


			element = ioschain("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]");
			if(element.isDisplayed()) {
				messageName = element.getText();

				// Creating the object of Touch Action
				@SuppressWarnings("rawtypes")
				TouchAction action = new TouchAction(IOsdriver);
				action.longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(10000)))
				.release().perform();
				flag = "false";
			}

			else {
				PrintValue("Scrolling to the given element");
				HashMap<String, Object> scrollObject = new HashMap<String, Object>();
				scrollObject.put("direction", Direction);
				scrollObject.put("xpath", element);
				IOsdriver.executeScript("mobile: scroll", scrollObject);
			}

		}
		return messageName;

	}

	public void longpress(WebElement Element) {

		TouchAction action = new TouchAction(IOsdriver);
		action.longPress(longPressOptions().withElement(element(Element)).withDuration(Duration.ofMillis(10000)))
		.release().perform();
	}

	public void killAndRelaunch() throws Throwable {
		IOsdriver.terminateApp(ReadProperties("bundleId", AppPropertiesFile));
		IOsdriver.launchApp();


	}

}
