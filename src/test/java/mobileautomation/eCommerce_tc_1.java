package mobileautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends AppiumConfiguration {

	@Test
	public void FillForm() throws InterruptedException {

		
		driver.findElement(
				By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"))
				.click();
		
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        Thread.sleep(2000);
		
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']")).click();

		/*
		 * driver.findElement( By.xpath(
		 * "//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"
		 * )) .sendKeys("Sriparna Saha");
		 */
		driver.hideKeyboard();
		driver.findElement(
				By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']"))
				.click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
            
           String toastmsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("text");
            Assert.assertEquals(toastmsg, "Please enter your name");
		/*
		 * WebElement listview =
		 * driver.findElement(By.xpath("(//android.widget.ListView)[0]")); Select
		 * dropdown = new Select(listview); dropdown.selectByVisibleText("India");
		 * Thread.sleep(2000);
		 */
		 

	}

}
