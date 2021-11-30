import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeTest
		public void initializeApp() throws MalformedURLException
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability("autoGrantPermissions", true);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "RealMeSan");
			caps.setCapability(MobileCapabilityType.UDID, "EE4SCI5DNNIJSS95");
			caps.setCapability(MobileCapabilityType.APP, "C:\\apks\\selendroid-test-app-0.17.0.apk");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
		}

	@AfterTest
	public void exitPage() {
		driver.quit();
	}

}
