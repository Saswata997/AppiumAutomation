package BasicConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumConfiguration {

	public AndroidDriver driver;
	public AppiumDriverLocalService service; // globally declared variable so that these can be accessed by any method
												// inside of the same class

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// To automate your Apps, first we have to use the android driver and to do that
		// we have to create object of the android driver first with arguments
		// Process -> Appium code => Appium Server => Mobile
		// .withAppiumJS expects file type arguments and AndroidDriver expects URL so to
		// convert it we have use new keyword URL, File

		// Configuration
		service = new AppiumServiceBuilder().withAppiumJS(new File(
				"C:\\Users\\CODECLOUDS-SASWATAC\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build(); // AppiumServiceBuilder is use to make the server
																		// run automatically
		service.start(); // starting appium server automatically

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Saswataemulator"); // UiAutomator2Options/options contains capabilities of device and app details
		options.setApp(
				"\\Users\\CODECLOUDS-SASWATAC\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\Api-debug.apk"); // Which
																																																							// to

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); // arguments => Server address,
																				// AndroidVersion(Capabilities)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void LongClickAction(WebElement longclick) {
                           
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap
				.of("elementId", ((RemoteWebElement) longclick).getId(), "duration", 2000));

	}
	
	public void scrollToEndAction() { //Do-While is used to cross check if there is a chance to scroll more until the end 
		
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 1.0
		));
		
		}while(canScrollMore);
	
	}
	
	public void swipeAction(WebElement webel, String direction) {
		
		 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			       "elementId", ((RemoteWebElement)webel).getId(),
			        "direction", direction,
			        "percent", 0.75
			    ));
	}
	

	@AfterClass
	public void tearDown() throws InterruptedException {

		Thread.sleep(4000);
		driver.quit();
		service.stop();
	}

}