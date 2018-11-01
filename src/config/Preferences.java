package config;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Preferences {
	WebDriver driver = ActionKeywords.driver;
	
	public static void changeLanguage (String language) {
		Select languageList = new Select(ActionKeywords.driver.findElement(By.id("LanguageID")));
		switch (language) {
		case "English":
		case "english":
			languageList.selectByIndex(0);
			break;
		case "Arabic" :
		case "arabic":
		case"⁄—»Ì":
			languageList.selectByIndex(1);
			break;
			
		case "French":
		case "french":
		case "FranÁais":
			languageList.selectByIndex(2);
			break;

		}
	}
	
	public static void changeDefaultHomePage () {
		Select HomePage = new Select(ActionKeywords.driver.findElement(By.id("DefaultHomePage")));
		WebElement options = HomePage.getFirstSelectedOption();
		if(options.getAttribute("value").equals("0")) {
			HomePage.selectByIndex(1);
		}
		else {
			HomePage.selectByIndex(0);
		}
	}
	
	public static void changeEditorialHomeScreen () {
		Select screens = new Select (ActionKeywords.driver.findElement(By.id("WebPreferredScreenID")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	public static void changeMobileHomeScreen () {
		Select screens = new Select (ActionKeywords.driver.findElement(By.id("PreferredScreenID")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	public static void changeListFontSize () {
		Select screens = new Select (ActionKeywords.driver.findElement(By.id("lsListFontSize")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	public static void changeEditorFontSize () {
		Select screens = new Select (ActionKeywords.driver.findElement(By.id("lsNewsFontSize")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	public static void changeDateFormat (String format, String customDate) {
		Select dateFormat = new Select (ActionKeywords.driver.findElement(By.id("lsDateTimeFormat")));
		switch (format) {
		case "Long Date" :
		case "long date":
		case " «—ÌŒ ÿÊÌ·":
			dateFormat.selectByIndex(0);
			break;
		case "Short Date" :
		case "short date":
		case " «—ÌŒ ﬁ’Ì—":
			dateFormat.selectByIndex(1);
			break;
			
		case "Time":
		case "time":
		case "Êﬁ ":
			dateFormat.selectByIndex(2);
			break;
			
		case"Custom":
		case"custom":
		case " Œ’Ì’":
			dateFormat.selectByIndex(3);
			ActionKeywords.driver.findElement(By.id("txtCustomDateTime")).clear();
			ActionKeywords.driver.findElement(By.id("txtCustomDateTime")).sendKeys(customDate);
			break;
		}
	}
	
	public static void changeCalendarType (String calendar) {
		Select calendarTypes = new Select(ActionKeywords.driver.findElement(By.id("lsCalendarType")));
		switch (calendar) {
		case "Hijri":
		case "hijri":
		case "ÂÃ—Ì":
			calendarTypes.selectByIndex(0);
			break;
		case "Gregorian":
		case "gregorian":
		case "„Ì·«œÌ":
			calendarTypes.selectByIndex(1);
			break;
			
		case "SystemDefault":
		case "System Default":
		case "system default":
		case "systemdefault":
		case "Õ”» «·‰Ÿ«„":
			calendarTypes.selectByIndex(2);
			break;
				
		}
	}
	
	public static void changeUsername (String newUsername) {
		ActionKeywords.driver.findElement(By.id("UserName")).clear();
		ActionKeywords.driver.findElement(By.id("UserName")).sendKeys(newUsername);
	}
	
	public static void changeEmail (String email) {
		ActionKeywords.driver.findElement(By.id("Email")).clear();
		ActionKeywords.driver.findElement(By.id("Email")).sendKeys(email);
	}
	
	public static void changeMobile (String mobileNumber) {
		ActionKeywords.driver.findElement(By.id("Mobile")).clear();
		ActionKeywords.driver.findElement(By.id("Mobile")).sendKeys(mobileNumber);
	}
	
	public static void changePassword (String currentPassword, String newPassword, String confirmNewPassword) {
		ActionKeywords.driver.findElement(By.id("Password")).sendKeys(currentPassword);
		ActionKeywords.driver.findElement(By.id("NewPassword")).sendKeys(newPassword);
		ActionKeywords.driver.findElement(By.id("ConfirmingPassword")).sendKeys(confirmNewPassword);
	}
	
	public static void cancelPreferences () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-white")).click();
	}

	public static void savePreferences () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

}
