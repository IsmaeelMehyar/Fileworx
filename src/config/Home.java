package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePage;

public class Home {
	
	WebDriver driver = ActionKeywords.driver;
	
	public static void click_Logout() {
		ActionKeywords.driver.findElement(By.cssSelector("i.fa.fa-sign-out")).click();
	}
	
	public static void click_Compose() {
	ActionKeywords.driver.findElement(By.cssSelector("i.fa.fa-pencil.fa-lg")).click();
	}
	
	public static void click_User () {
		ActionKeywords.driver.findElement(By.cssSelector("span.block.m-t-xs")).click();
	}
	
	public static void click_Preferences() {
		//The if statement here is to check the UI language by checking the caption of "My Workflow Screens" section since we used find by linkText which is case sensitive
		if (HomePage.workflowScreens(ActionKeywords.driver).getText().contains("My Workflow Screens")){
			ActionKeywords.driver.findElement(By.partialLinkText("Preferences")).click();}
		
		else if (HomePage.workflowScreens(ActionKeywords.driver).getText().contains("Mon flux de travail")) {
			ActionKeywords.driver.findElement(By.partialLinkText("PrÈfÈrences")).click();
		}
		else {
			ActionKeywords.driver.findElement(By.partialLinkText("«· ›÷Ì·« ")).click();
		}
	}
	
	public static void selectModule (String moduleName) {
		//If you want to open a screen inside an already expanded module, first web driver will click the module 
		//so it will be collapsed, Therefore web driver will not be able to locate the screen inside this module.
		//So we found that all Modules are in tag of type <li> and the expanded module will has 
		//extra attribute called <class> with value "active" --> <li class="active">.
		//So we will check if Module element has a parent tag with <class="active"> we will pass clicking on it.
		
		//We locate the side menu element that has all the Modules.
		WebElement sideMenu = ActionKeywords.driver.findElement(By.id("side-menu"));
		//Then located the selected Module that you want to click inside the side menu element. 
		WebElement module = sideMenu.findElement(By.xpath("//span[@class='nav-label' and contains(text(),"+moduleName+")]"));
		//Then located the parent of the module element which is tag of type <a>
		WebElement parent = module.findElement(By.xpath(".."));
		//Then locate the parent of <a> tag element which is <li> element
		WebElement parent2 = parent.findElement(By.xpath(".."));
		//check if <li> tag does not has an attribute <class> with the value "active" we will click on it
		if (!parent2.getAttribute("class").equals("active")) {
			//ActionKeywords.driver.findElement(By.xpath("//span[@class='nav-label' and normalize-space()='moduleName']")).click();
			ActionKeywords.driver.findElement(By.xpath("//span[@class='nav-label' and contains(text(),'"+moduleName+"')]")).click();
		}
	}
	
	public static void selectScreen (String screenName){
		//Note that find by linkText is case sensitive
		ActionKeywords.driver.findElement(By.linkText(screenName)).click();
	}
	
	public static void selectWorkflowScreen (String workflowScreen) {
		ActionKeywords.driver.findElement(By.xpath("//label[@class='center-block m-t-xs' and contains(text(), '"+workflowScreen+"')]")).click();
	}
	
	public static void selectAgencyScreen (String agencyScreen) {
		ActionKeywords.driver.findElement(By.xpath("//label[@class='center-block' and contains(text(), '"+agencyScreen+"')]")).click();
	}

}
