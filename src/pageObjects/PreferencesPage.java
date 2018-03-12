package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PreferencesPage {
	
	private static WebElement element = null;
	
	public static WebElement preferredLanguage (WebDriver driver) {
		element = driver.findElement(By.id("LanguageID"));
		return element;
	}
	
	public static WebElement defaultHomePage (WebDriver driver) {
		element = driver.findElement(By.id("DefaultHomePage"));
		return element;
	}
	
	public static WebElement mobileHomeScreen (WebDriver driver) {
		element = driver.findElement(By.id("PreferredScreenID"));
		return element;
	}
	
	public static WebElement calendarType (WebDriver driver) {
		element = driver.findElement(By.id("lsCalendarType"));
		return element;
	}
	
	public static WebElement dateFormat (WebDriver driver) {
		element = driver.findElement(By.id("lsDateTimeFormat"));
		return element;
	}
	
	public static WebElement sampleDate (WebDriver driver) {
		element = driver.findElement(By.id("txtSampleDate"));
		return element;
	}
	
	public static WebElement listFontSize (WebDriver driver) {
		element = driver.findElement(By.id("lsListFontSize"));
		return element;
	}
	
	public static WebElement editorFontSize (WebDriver driver) {
		element = driver.findElement(By.id("lsNewsFontSize"));
		return element;
	}
	
	public static WebElement username (WebDriver driver) {
		element = driver.findElement(By.id("UserName"));
		return element;
	}
	
	public static WebElement mobile (WebDriver driver) {
		element = driver.findElement(By.id("Mobile"));
		return element;
	}
	
	public static WebElement email (WebDriver driver) {
		element = driver.findElement(By.id("Email"));
		return element;
	}
	
	public static WebElement currentPassword (WebDriver driver) {
		element = driver.findElement(By.id("Password"));
		return element;
	}
	
	public static WebElement newPassword (WebDriver driver) {
		element = driver.findElement(By.id("NewPassword"));
		return element;
	}
	
	public static WebElement confirmNewPassword (WebDriver driver) {
		element = driver.findElement(By.id("ConfirmingPassword"));
		return element;
	}
	
	public static WebElement cancelBtn (WebDriver driver) {
		element = driver.findElement(By.cssSelector("button.btn.btn-white"));
		return element;
	}
	
	public static WebElement saveBtn (WebDriver driver) {
		element = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		return element;
	}

}
