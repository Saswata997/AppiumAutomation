package mobileautomation;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void WifiSettingsName() throws MalformedURLException, InterruptedException {

		// actual automation
		// locators -> xpath, id, accessibilityId, classname, androidUIAutomator

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc= '3. Preference dependencies']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click(); 
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings"); //Verifying if the title text is present in the alertbox //arguments = (expected, actual)
        
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("Saswata Wifi");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
         
	
	
	}

}
