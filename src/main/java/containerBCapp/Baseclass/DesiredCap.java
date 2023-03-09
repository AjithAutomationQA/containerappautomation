package containerBCapp.Baseclass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class DesiredCap extends CommonUtilities {
	
	public  void LaunchIosApp() throws Throwable {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("platformName", ReadProperties("platformName", AppPropertiesFile));
		desiredCapabilities.setCapability("deviceName", ReadProperties("deviceName", AppPropertiesFile));

		desiredCapabilities.setCapability("udid", ReadProperties("udid", AppPropertiesFile));
		desiredCapabilities.setCapability("automationName", ReadProperties("automationName", AppPropertiesFile));
		desiredCapabilities.setCapability("xcodeOrgId", ReadProperties("xcodeOrgId", AppPropertiesFile));
		desiredCapabilities.setCapability("xcodeSigningId", ReadProperties("xcodeSigningId", AppPropertiesFile));
		desiredCapabilities.setCapability("appium:bundleId", ReadProperties("bundleId", AppPropertiesFile));
		IOsdriver = new IOSDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
		IOsdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
