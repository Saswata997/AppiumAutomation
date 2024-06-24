package mobileautomation;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class LongPress extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void longPressGesture() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		// performing longclick operation = ImmutableMap.of(elementID,
		// ((RemoteWebElement)eventname).getId(), "duration", time)
         
		WebElement longclick = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		LongClickAction(longclick);

		String longclicktext = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).getText();
		
		Assert.assertEquals(longclicktext, "Sample menu");
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).isDisplayed());	    
	}

	
	
}
