package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage {
	private static WebElement element = null;
	
	public static WebElement logoutBtn(WebDriver driver) {
		element = driver.findElement(By.linkText("Log Out"));
		return element;
	}
	
	public static WebElement logoutAr(WebDriver driver) {
		element = driver.findElement(By.partialLinkText(" ”ÃÌ· Œ—ÊÃ"));
		return element;
	}
	
	public static WebElement workflowScreens (WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div[1]/div/div/div[1]/h5"));
		return element;
	}
	
	public static WebElement composeNews(WebDriver driver) {
		element = driver.findElement(By.cssSelector("i.fa.fa-pencil.fa-lg"));
		return element;
	}
	
	public static WebElement userPreferences(WebDriver driver) {
		element = driver.findElement(By.cssSelector("span.block.m-t-xs"));
		return element;
	}
	
	public static WebElement preferences(WebDriver driver) {
		element = driver.findElement(By.linkText("Preferences"));
		return element;
	}
	
	public static WebElement preferencesAr (WebDriver driver) {
		element = driver.findElement(By.linkText("«· ›÷Ì·« "));
		return element;
	}
	
	public static WebElement home(WebDriver driver) {
		element = driver.findElement(By.cssSelector("i.fa.fa-home"));
		return element;
	}
	
	public static WebElement mediaPortal(WebDriver driver) {
		element = driver.findElement(By.cssSelector("i.fa.fa-video-camera"));
		return element;
	}

}
