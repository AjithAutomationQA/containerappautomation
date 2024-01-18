package containerBCapp.Baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.ios.options.XCUITestOptions;

import io.appium.java_client.ios.IOSDriver;

public class Capabilities extends CommonUtilities {
	private static String userName = "toolsanywhere";
	private static String accessKey = "s5t8PltjS8NKvxu02qPYfSKkTSSdvPeiauFUDHPkmsfgDqXKzS";

	private static String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
	public static void launchLambdaDevice() throws Throwable {

		// Migrating to appium 2.X


		String deviceName = ReadProperties("deviceName");
		String platformVersion = ReadProperties("platformVersion");
		String platformName = ReadProperties("platformName");
		String automationName = ReadProperties("automationName");
		String udid = ReadProperties("udid");
		String bundleId = ReadProperties("bundleId");
		String xcodeSigningId = ReadProperties("xcodeSigningId");
		String xcodeOrgId = ReadProperties("xcodeOrgId");
		String hub = "https://" + userName + ":" + accessKey + gridURL;

		// capabilities for launching the Lambda device :-
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone XR");
		options.setPlatformName("ios");
		options.setPlatformVersion("15");
		options.setAutomationName("XCUITest");
		options.setCapability("deviceOrientation", "PORTRAIT");
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("autoAcceptAlerts", true);
		options.setCapability("build", "Container App");
		options.setCapability("name", "BC Mobile-iOS");
		options.setCapability("isRealMobile", true);
		options.setCapability("app", "lt://APP10160241051704963851730719");
		options.setCapability("w3c", true);
		options.setCapability("xcodeSigningId", xcodeSigningId);
		options.setCapability("xcodeOrgId", xcodeOrgId);
		options.setShowXcodeLog(true);

		IOsdriver = new IOSDriver(new URL(hub), options);

		IOsdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("App launched in "+deviceName+ " successfully");

	}

	public static void launchRealDevice() throws Throwable{

		String deviceName = ReadProperties("deviceName");
		String platformVersion = ReadProperties("platformVersion");
		String platformName = ReadProperties("platformName");
		String automationName = ReadProperties("automationName");
		String udid = ReadProperties("udid");
		String bundleId = ReadProperties("bundleId");
		String xcodeSigningId = ReadProperties("xcodeSigningId");
		String xcodeOrgId = ReadProperties("xcodeOrgId");

		XCUITestOptions options =new XCUITestOptions();
		options.setDeviceName(deviceName);
		options.setPlatformName(platformName);
		options.setPlatformVersion(platformVersion);
		options.setAutomationName(automationName);
		options.setUdid(udid);
		options.setBundleId(bundleId);
		options.setCapability("xcodeSigningId", xcodeSigningId);
		options.setCapability("xcodeOrgId", xcodeOrgId);
		IOsdriver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
		IOsdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("App launched in "+deviceName+ " successfully");
	}

}
