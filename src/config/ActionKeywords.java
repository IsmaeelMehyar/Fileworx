package config;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class ActionKeywords {
	public static WebDriver driver;
	
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void navigate() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://mays/SEDCOWebServer/");
	}
	
	public static void waitFor(int waitTime) throws Exception {
		int wait = waitTime*1000;
		Thread.sleep(wait);
	}
		
}