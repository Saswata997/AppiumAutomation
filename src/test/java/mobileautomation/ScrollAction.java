package mobileautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class ScrollAction extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void scrollAction() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	    Thread.sleep(2000);
	
	
	}

	
	
}
