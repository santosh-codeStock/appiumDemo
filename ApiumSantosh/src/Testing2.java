import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Testing2 extends Base{
	
	
	By permission =  By.id("com.android.permissioncontroller:id/continue_button");
	By okBtn =  By.xpath("//android.widget.Button[@text='OK']");
	By serachText = By.id("io.selendroid.testapp:id/my_text_field");
	By searchBtn = By.id("io.selendroid.testapp:id/waitingButtonTest");
	By userName = By.id("io.selendroid.testapp:id/inputUsername");	
	By email = By.id("io.selendroid.testapp:id/inputEmail");
	By password = By.id("io.selendroid.testapp:id/inputPassword");
	By name = By.id("io.selendroid.testapp:id/inputName");
	By checkbox = By.xpath("//android.widget.CheckBox[@text='I accept adds']");
	By register = By.id("io.selendroid.testapp:id/btnRegisterUser");
	By verifyPage = By.xpath("//android.widget.TextView[@text='Verify user']");
	

	@Test
	public void HomeSearchPage() throws InterruptedException {
		
		driver.findElement(permission).click();
		driver.findElement(okBtn).click();
		Thread.sleep(2000);
		driver.findElement(serachText).sendKeys("Testing");		
			Thread.sleep(2000);
		driver.findElement(searchBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
	}
	
	@Test
	public void HomePage() {
		driver.findElement(userName).sendKeys("demotest");
		driver.findElement(email).sendKeys("demo@abc.com");
		driver.findElement(password).sendKeys("demotest");
		driver.findElement(name).sendKeys("mr demo");
		driver.findElement(checkbox).click();
		driver.findElement(register).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyPage));
	}
	
	
}
