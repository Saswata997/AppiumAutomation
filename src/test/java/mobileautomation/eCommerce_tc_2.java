package mobileautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends AppiumConfiguration {

	@Test
	public void FillForm() throws InterruptedException {

		driver.findElement(
				By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"))
				.click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Argentina']"))
				.click();

		driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']"))
				.sendKeys("Sriparna Saha");

		driver.hideKeyboard();
		driver.findElement(
				By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']"))
				.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));"));
	
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i = 0; i<productCount; i++) {
			
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("PG 3")) {
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			
			}
		
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//waiting until Product page redirects into cart page to start the product validation
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	
		String CartpageProductText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).getText();
		
		Assert.assertEquals(CartpageProductText, "PG 3");
	
	}

}
