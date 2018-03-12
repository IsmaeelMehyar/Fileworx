package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element = null;
	
	public static WebElement userName(WebDriver driver) {
		element = driver.findElement(By.id("txtUserName"));
		return element;
	}
	
	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.id("txtPassword"));
		return element;
	}
	
	public static WebElement loginBtn(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		return element;
	}

}
