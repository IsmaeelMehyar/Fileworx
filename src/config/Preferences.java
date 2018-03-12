package config;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Random;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

import pageObjects.HomePage;
import utility.Constant;

public class Preferences {
	public static WebDriver driver;
	
	public static void changeLanguage (String language) {
		Select languageList = new Select(driver.findElement(By.id("LanguageID")));
		switch (language) {
		case "English":
			languageList.selectByIndex(0);
			break;
		case "Arabic" :
			languageList.selectByIndex(1);
			break;
			
		case "French":
			languageList.selectByIndex(2);
			break;
			
		case"ÚÑÈí":
			languageList.selectByIndex(1);
			break;
			
		case "Français":
			languageList.selectByIndex(2);
			break;
		}
	}

}
