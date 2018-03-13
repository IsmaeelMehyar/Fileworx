package config;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver = ActionKeywords.driver;
	
	public static void input_Username(String username) {
		ActionKeywords.driver.findElement(By.id("txtUserName")).sendKeys(username);
	}
	
	public static void input_Password(String password) {
		ActionKeywords.driver.findElement(By.id("txtPassword")).sendKeys(password, Keys.ENTER);
	}
	
	public static void click_Login() throws Exception {
		Thread.sleep(500);
		ActionKeywords.driver.findElement(By.cssSelector("button.ladda-button.ladda-button-demo.btn.btn-primary[type=submit]")).click();
	}

}
