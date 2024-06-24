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

public class DragDropAction extends AppiumConfiguration { // Accessing parent class properties

	@Test
	public void DragAndDropAction() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	    WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	    
	 
	    ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
	        "elementId", ((RemoteWebElement) source).getId(),
	        "endX", 653,
	        "endY", 586
	    ));
	   
	    String dragResultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
	    
	    Assert.assertEquals(dragResultText, "Dropped!");
	  
	    
	    
	    Thread.sleep(3000);
	
	
	
	}

	
	
}
