package containerBCapp.Baseclass;

import java.net.URL;

import io.appium.java_client.ios.options.XCUITestOptions;

import io.appium.java_client.ios.IOSDriver;

public class Capabilities extends CommonUtilities {
	
	public static void LaunchIosApp() throws Throwable {

		// Migrating to appium 2.X

		String deviceName = ReadProperties("deviceName", AppPropertiesFile);
		String platformVersion = ReadProperties("platformVersion", AppPropertiesFile);
		String platformName = ReadProperties("platformName", AppPropertiesFile);
		String automationName = ReadProperties("automationName", AppPropertiesFile);
		String udid = ReadProperties("udid", AppPropertiesFile);
		String bundleId = ReadProperties("bundleId", AppPropertiesFile);
		String xcodeSigningId = ReadProperties("xcodeSigningId", AppPropertiesFile);
		String xcodeOrgId = ReadProperties("xcodeOrgId", AppPropertiesFile);

		// capabilities for launching the real device :-
		XCUITestOptions options =new XCUITestOptions();
		options.setDeviceName(deviceName);
		options.setPlatformName(platformName);
		options.setPlatformVersion(platformVersion);
		options.setAutomationName(automationName);
		options.setUdid(udid);
		options.setBundleId(bundleId);
		options.setCapability("xcodeSigningId", xcodeSigningId);
		options.setCapability("xcodeOrgId", xcodeOrgId);
		options.setShowXcodeLog(true);
		IOsdriver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
	}

}
