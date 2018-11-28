package config;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {
	static WebDriver driver = ActionKeywords.driver;
	static WebDriverWait wait;
	public static void Select_Item () throws Exception {
		
		ActionKeywords.driver.findElement(By.cssSelector ("button.btn.btn-primary.dropdown-toggle.btn-start-selection")).click();

	}
	
	public static void Select_News() {
		
		WebElement table = ActionKeywords.driver.findElement(By.cssSelector("div.k-grid-content.k-auto-scrollable"));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
	    rows.get(0).click();
	}
	
	public static void Upload_Files() {
		WebElement createNewBtn = ActionKeywords.driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/div[1]/div/div/button"));
		createNewBtn.click();
		ActionKeywords.driver.findElement(By.linkText("Upload Files")).click();
	}
	
	public static void Open_Tasks () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn-primary.dropdown-toggle.btn-selected-items")).click();
	}
	
	public static void Select_Task(String taskName ) throws InterruptedException {
		
		ActionKeywords.driver.findElement(By.linkText(taskName)).click();
		//Open_Tasks();
		// Check if a confirmation message is displayed, if there is no confirmation message the test will continue and ignore the if statement 
		if (IsConfirmationMsg()){
			//If confirmation message is displayed click yes
			ActionKeywords.driver.findElement(By.id("popup-btn-Yes")).click();
		}
	}
	
	// This function checks if a confirmation message is displayed when a class is selected from tasks list
	public static boolean IsConfirmationMsg() throws InterruptedException{
		try{
			wait= new WebDriverWait(ActionKeywords.driver, 5);
			WebElement confirmationMsg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ConfirmPopup")));
			return confirmationMsg.isDisplayed();
		}
		catch (Exception e){
			return false;
		}
	}
	
	public static void Search (String searchText) {
		ActionKeywords.driver.findElement(By.id("txtSearchTerm")).sendKeys(searchText);
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-primary.btn-search-screen")).click();
	}
	
	public static void ChangeViewToDetails () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-sm.btn-default.dropdown-toggle")).click();
		WebElement test = ActionKeywords.driver.findElement(By.cssSelector("span.m-r-sm.text-muted.welcome-message"));
		if (test.getText().contains("Welcome to Fileworx")) {
			ActionKeywords.driver.findElement(By.linkText("Details")).click();
		}
		else {
			ActionKeywords.driver.findElement(By.linkText(" ›«’Ì·")).click();
		}
	}
	
	public static void ChangeViewToDetailsWithThumbnail () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-sm.btn-default.dropdown-toggle")).click();
		WebElement test = ActionKeywords.driver.findElement(By.cssSelector("span.m-r-sm.text-muted.welcome-message"));
		if (test.getText().contains("Welcome to Fileworx")) {
			ActionKeywords.driver.findElement(By.linkText("Thumbnails with Details")).click();
		}
		else {
			ActionKeywords.driver.findElement(By.linkText("’Ê— „’€¯—… „⁄  ›«’Ì·")).click();
		}
	}
	
	public static void ChangeViewToThumbnail () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-sm.btn-default.dropdown-toggle")).click();
		WebElement test = ActionKeywords.driver.findElement(By.cssSelector("span.m-r-sm.text-muted.welcome-message"));
		if (test.getText().contains("Welcome to Fileworx")) {
			ActionKeywords.driver.findElement(By.linkText("Thumbnails")).click();
		}
		else {
			ActionKeywords.driver.findElement(By.linkText("’Ê— „’€¯—…")).click();
		}
	}
	
	public static void ChangeViewToWebCustomView () {
		ActionKeywords.driver.findElement(By.cssSelector("button.btn.btn-sm.btn-default.dropdown-toggle")).click();
		WebElement test = ActionKeywords.driver.findElement(By.cssSelector("span.m-r-sm.text-muted.welcome-message"));
		if (test.getText().contains("Welcome to Fileworx")) {
			ActionKeywords.driver.findElement(By.linkText("Web Custom View")).click();
		}
		else {
			ActionKeywords.driver.findElement(By.linkText("⁄—÷ „Œ’’ ··ÊÌ»")).click();
		}
	}
	
}
