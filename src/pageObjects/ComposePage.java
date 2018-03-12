package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ComposePage {
	private static WebElement element = null;
	
	public static WebElement title(WebDriver driver) {
		element = driver.findElement(By.id("txtTitle"));
		return element;
	}
	
	public static WebElement tagLvl1(WebDriver driver) {
		element = driver.findElement(By.id("Classifications_FirstLevel"));
		return element;
	}
	
	public static WebElement tagLvl2(WebDriver driver) {
		element = driver.findElement(By.id("Classifications_SecondLevel"));
		return element;
	}
	
	public static WebElement tagLvl3(WebDriver driver) {
		element = driver.findElement(By.id("Classifications_ThirdLevel"));
		return element;
	}
	
	public static WebElement tagLvl4(WebDriver driver) {
		element = driver.findElement(By.id("Classifications_FourthLevel"));
		return element;
	}
	
	public static WebElement category(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div.chosen-container.chosen-container-multi"));
		return element;
	}
	
	public static WebElement event(WebDriver driver) {
		element = driver.findElement(By.id("ddlEvent"));
		return element;
	}
	
	public static WebElement task(WebDriver driver) {
		element = driver.findElement(By.id("ddlEventTask"));
		return element;
	}
	
	public static WebElement send(WebDriver driver) {
		element = driver.findElement(By.id("btn-toggle-tasks-list"));
		return element;
	}
	
	public static WebElement save(WebDriver driver) {
		element = driver.findElement(By.id("btnSaveHeader"));
		return element;
	}
	
	public static WebElement discard(WebDriver driver) {
		element = driver.findElement(By.id("btnDiscardHeader"));
		return element;
	}
	
	public static WebElement attach(WebDriver driver) {
		element = driver.findElement(By.id("btnAttachments"));
		return element;
	}
	
	public static WebElement notesBtn(WebDriver driver) {
		element = driver.findElement(By.id("btnNotes"));
		return element;
	}
	
	public static WebElement notesTxt(WebDriver driver) {
		element = driver.findElement(By.id("Notes"));
		return element;
	}
	
	public static WebElement share(WebDriver driver) {
		element = driver.findElement(By.id("btnNotes"));
		return element;
	}
	
	public static WebElement body (WebDriver driver) {
		element = driver.findElement(By.id("cke_1_contents"));
		return element;
	}

}
