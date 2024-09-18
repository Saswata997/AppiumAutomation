package mobileautomation;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousActions extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void miscellaneousActivities() throws MalformedURLException, InterruptedException {

		// actual automation
		// locators -> xpath, id, accessibilityId, classname, androidUIAutomator

		//Direct opening the required activity/page of the app by usig Activity class
		//Package/Activity ==> this is the form the focus that will appear in cmd
		
		
		 ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			   "intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
			    ));
			   
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();

		// Changing of device orientation

		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings"); // Verifying if the title text is present in the alertbox
														 //arguments = (expected, actual)

		//Copied to clipboard - gesture code
		
		driver.setClipboardText("Saswata Wifi");
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']"))
				.sendKeys(driver.getClipboardText());
		//keynote action code
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME)); //pressing home button
		
		
		

	}

}
