package config;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	public static void Select_Task() throws InterruptedException {
		
		ActionKeywords.driver.findElement(By.linkText("SLeader Ar")).click();
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
	

}
