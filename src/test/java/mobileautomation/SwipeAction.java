package mobileautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class SwipeAction extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void scrollAction() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	    driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"), "true");
	    //assertion to check if the focusable value for the first image is true by keeping it selected initially 
	    WebElement firstImage = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
	    //Swipe code
	
	    swipeAction(firstImage, "left");
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"), "false");

	    
	
	
	}

	
	
}
