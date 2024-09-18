package mobileautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasicConfiguration.AppiumConfiguration;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends AppiumConfiguration {

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

		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();		
		
		//waiting until Product page redirects into cart page to start the product validation
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
	    
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();		
	   double sum = 0;
		for(int i = 0; i<count; i++) {
			
			String priceAmount = productPrices.get(i).getText();
			Double actualPrice = Double.parseDouble(priceAmount.substring(1)); // For $ sign inorder to perform addition we have to remove $ sign from the entire string   
                		                                    //Inorder to convert string into double we use Double.parseDouble/Float.parseFloat 
		    sum = sum + actualPrice;
               		
		}  
		
		String sumDisplay = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double FormattedSum = getConvertedAmount(sumDisplay);
		Assert.assertEquals(sum, FormattedSum);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongClickAction(ele);
	    driver.findElement(By.id("android:id/button1")).click();
	    driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	    driver.findElement(AppiumBy.className("android.widget.Button")).click();
	    Thread.sleep(2000);
	    
	    
	    
	    
	    
	}

}
