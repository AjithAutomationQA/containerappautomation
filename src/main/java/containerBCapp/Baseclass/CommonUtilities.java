package containerBCapp.Baseclass;

import static io.appium.java_client.MobileBy.*;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtilities {

    public static AppiumDriverLocalService service;
    public static Properties Prop;
    public static String Locator;
    public static File FileLocation;
    public static IOSDriver IOsdriver;
    public static String LocatorPropertiesFile = "./src/test/resources/Properties/Xpath.properties";
    public static String AppPropertiesFile = "./src/test/resources/Properties/App.properties";
    public static String ExcelFile = "./TestData/AnswerConnectData.xlsx";

    public Faker testdata;
    public String randomString;
    public String locator;

    public String message;

    public static AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerRunning(4723);
        if (!flag) {
            AppiumServiceBuilder builder = new AppiumServiceBuilder();
            builder
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.USE_PLUGINS, "element-wait@2.0.3")
                    .withLogFile(new File("test-output/AppiumLogs/" + "AppiumLog.txt"));
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerRunning(int portNumber) {
        boolean isServerRunning = false;
        ServerSocket serversocket;
        try {
            serversocket = new ServerSocket(portNumber);
            serversocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        }
        return isServerRunning;
    }

    @SuppressWarnings("static-access")
    public static void lauchTheApp() throws Throwable {

        Capabilities capabilities = new Capabilities();
        capabilities.LaunchIosApp();

//		Capabilities capabilities = new Capabilities();
//		service = startServer();
//		capabilities.LaunchIosApp();

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

        if (LocatorType.equalsIgnoreCase("accessibility"))
            return IOsdriver.findElement(AppiumBy.accessibilityId(LocatorValue));

        else if (LocatorType.equalsIgnoreCase("xpath"))
            return IOsdriver.findElement(AppiumBy.xpath(LocatorValue));

        else if (LocatorType.equalsIgnoreCase("iOSClassChain"))
            return IOsdriver.findElement(AppiumBy.iOSClassChain(LocatorValue));

        else
            throw new Exception("Unknown locator type '" + LocatorType + "'");

    }

    public void waitFor(WebElement element) throws Throwable {

        WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

//	public void waitForTheElement(String Locator, String locatorfile) throws Throwable {
//
//		WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(60));
//		WebElement element = getElement(Locator, locatorfile);
//
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//
//	}

    public WebElement getMobileElement(String Locator, String locatorfile) throws Throwable {

        WebDriverWait wait = new WebDriverWait(IOsdriver, Duration.ofSeconds(20));
        WebElement element = getElement(Locator, locatorfile);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
        return element;

    }

    public WebElement isElementDisplayed(String Locator, String locatorfile) throws Throwable {

        WebElement element = getMobileElement(Locator, locatorfile);
        Assert.assertTrue(element.isDisplayed());
        return element;
    }


    public boolean isElementDisplayed(WebElement element) throws Throwable {

          Assert.assertTrue(element.isDisplayed());
        return true;
    }

    public boolean isNotElementDisplayed(WebElement element) throws Throwable {

        Assert.assertFalse(element.isDisplayed());
        return false;
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

    public void assertMessageName(String messageName, String Text) throws Throwable {

        if (messageName.equalsIgnoreCase(Text)) {
            PrintValue("Message name is verified");
        }

    }

    public void assertTextFalse(String toastText, String Text) throws Throwable {

        Assert.assertFalse(toastText.equalsIgnoreCase(Text));
    }

    public void assertEquals(WebElement element, String input, String name) {

        String getheadertext = element.getText();
        Assert.assertEquals(input, getheadertext);
        PrintValue(name);
    }



    //<This is a common method to verify the toast message>
    public void toastMessage(String Text) throws Throwable {

        WebElement toastElement = IOsdriver
                .findElement(AppiumBy.iOSClassChain(("**/XCUIElementTypeStaticText[`label == \"" + Text + "\"`]")));
        isElementDisplayed(toastElement);

        String toastText = toastElement.getText();
        assertTextValue(toastText, Text);
        PrintValue("Toast Message: " + toastText);
    }

    public void reportLog(String Log) {
        ExtentCucumberAdapter.addTestStepLog(Log);
    }

    public void PrintValue(String Value) {

        System.out.println(Value);
    //   reportLog(Value);
    }

    public void PrintError(String Value) {

        System.err.println(Value);
    }

    public void faker() {

        testdata = new Faker();
    }


    public void random() {
        // Generate a random string of length 10 containing letters and digits
        randomString = RandomStringUtils.randomPrint(10);
    }

    public void ScrollToElement(String Xpath, String Direction) {

        JavascriptExecutor js = (JavascriptExecutor) IOsdriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", Direction);
        scrollObject.put("xpath", Xpath);
        js.executeScript("mobile: scroll", scrollObject);

    }

    public WebElement findElementByText(String text) {

         locator = "//XCUIElementTypeStaticText[@name=" + "\"" + text + "\"" + "]";
        return IOsdriver.findElement(xpath((locator)));

    }

    public WebElement findElementByxpath(String text) {


        return IOsdriver.findElement(xpath((text)));
    }

    public WebElement findElementById(String text) {


        return IOsdriver.findElement(accessibilityId((text)));
    }

    public WebElement findElementByName(String Name) {

        return IOsdriver.findElement(iOSClassChain(("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]")));
    }


    public String swipeRightToLeft(String Name, String Direction) throws Throwable {

        String flag = "False";
        String messageName = null;
        PrintValue("Looking for the given message");
        while (flag == "False") {


            WebElement element = IOsdriver.findElement(iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]"));
            if (element.isDisplayed()) {
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
            } else {
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
        if (Element.isDisplayed()) {
            text = Element.getText();
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

        return IOsdriver.findElement(AppiumBy.iOSClassChain(inboxMessage));
    }

//    public WebElement scroll(String Name, String Direction) throws Throwable {
//
//        String flag = "False";
//        WebElement element = null;
//
//        while (flag.equals("False")) {
//
//        //     element = IOsdriver.findElement(AppiumBy.id(Name));
//       //     element.click();
//          //  String LocatorValue = "//XCUIElementTypeStaticText[`label == \""+Name+"\"`]";
//
//         //   PrintValue(LocatorValue);
//
//         //   element = IOsdriver.findElement(AppiumBy.xpath(LocatorValue));
//
//            String xpathExpression = String.format("//XCUIElementTypeStaticText[contains(@label, '%s')]", Name);
//            element =   IOsdriver.findElement(AppiumBy.xpath(xpathExpression));
//
//
//           //   element = ioschain("**/XCUIElementTypeStaticText[`label == \"" + Name + "\"`]");
//            if (element.isDisplayed()) {
//                PrintValue("Message found");
//                flag = "false";
//            } else {
//                PrintValue("Scrolling to the given element");
//                HashMap<String, Object> scrollObject = new HashMap<String, Object>();
//                scrollObject.put("direction", Direction);
//                scrollObject.put("xpath", element);
//                IOsdriver.executeScript("mobile: scroll", scrollObject);
//            }
//
//        }
//        return element;
//    }

    public WebElement scroll(String name) throws Throwable {
        WebElement element = null;

        while (element == null) {
            // Construct the XPath expression with the provided 'name'
            String xpathExpression = String.format("//XCUIElementTypeStaticText[contains(@label, '%s')]", name);

            try {
                // Attempt to find the element
                element = IOsdriver.findElement(AppiumBy.xpath(xpathExpression));

                // Check if the element is displayed
                if (element.isDisplayed()) {
                    PrintValue("Element found: " + name);
                }
            } catch (NoSuchElementException e) {
                // Element not found, scroll in the specified direction
                Duration duration = Duration.ofMillis(500); // Adjust as needed

                PrintValue("Scrolling to find element: " + name);
                int height = IOsdriver.manage().window().getSize().getHeight();
                int width = IOsdriver.manage().window().getSize().getWidth();
                int startX = width / 2;
                int startY = (int) (height * 0.8); // You can adjust the startY position as needed
                int endY = (int) (height * 0.2); // You can adjust the endY position as needed

                TouchAction touchAction = new TouchAction(IOsdriver);
                touchAction.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(duration))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
            }
        }

        return element;

    }


    public WebElement scrollUntilElement(WebElement Ele) throws Throwable {
        while(!isElementDisplayed(Ele)) {
            Dimension size =  IOsdriver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.25);
            PointerInput finger1 =  new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            IOsdriver.perform(Collections.singletonList(sequence));
        }
        return Ele;
    }


    public String longPress(WebElement element) {

        String messageName = null;
        if (element.isDisplayed()) {
            messageName = element.getText();

            // Creating the object of Touch Action
            @SuppressWarnings("rawtypes")
            TouchAction action = new TouchAction(IOsdriver);
            action.longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(10000)))
                    .release().perform();
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
        try {
            tapTheElement("Skip", LocatorPropertiesFile);
        } catch (Exception e) {


        }
    }}


