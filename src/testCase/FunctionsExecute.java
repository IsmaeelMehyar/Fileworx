package testCase;
import appModule.*;
import utility.Constant;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FunctionsExecute {
	
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.url);
		LoginAction.Excute(driver);
		HomePage.composeNews(driver).click();
		ComposeNewsAction.Execute(driver, "test body", "test note");

	}

}
