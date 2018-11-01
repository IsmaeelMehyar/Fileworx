package config;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screen {
	
	WebDriver driver = ActionKeywords.driver;
	public static void Select_Item () throws Exception {
		
		ActionKeywords.driver.findElement(By.cssSelector ("button.btn.btn-primary.dropdown-toggle.btn-start-selection")).click();

	}
	
	public static void Select_News() {
		
		WebElement table = ActionKeywords.driver.findElement(By.cssSelector("div.k-grid-content.k-auto-scrollable"));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
	    rows.get(0).click();
	}
	
	public static void Open_Tasks () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn-primary.dropdown-toggle.btn-selected-items")).click();
	}
	
	public static void Select_Task() {
		ActionKeywords.driver.findElement(By.linkText("Quotation")).click();
	}
	
	

}
