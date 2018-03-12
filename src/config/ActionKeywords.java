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

public class ActionKeywords {
	public static WebDriver driver;
	
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void navigate() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.url);
	}
	
	public static void input_Username(String username) {
		driver.findElement(By.id("txtUserName")).sendKeys(username);
	}
	
	public static void input_Password(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}
	
	public static void click_Login() throws Exception {
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("submit"))));
		driver.findElement(By.cssSelector("button.ladda-button.ladda-button-demo.btn.btn-primary[type=submit]")).click();
	}
	
	public static void waitFor(int waitTime) throws Exception {
		int wait = waitTime*1000;
		Thread.sleep(wait);
	}
	
	public static void click_Logout() {
		driver.findElement(By.cssSelector("i.fa.fa-sign-out")).click();
	}
	
	public static void click_User () {
		driver.findElement(By.cssSelector("span.block.m-t-xs")).click();
	}
	
	public static void click_Preferences () {
		//The if statement here is to check the UI language by checking the caption of "My Workflow Screens" section since we used find by linkText which is case sensitive
		if (HomePage.workflowScreens(driver).getText().contains("My Workflow Screens")){
		driver.findElement(By.partialLinkText("Preferences")).click();}
		
		else if (HomePage.workflowScreens(driver).getText().contains("Mon flux de travail")) {
			driver.findElement(By.partialLinkText("PrÈfÈrences")).click();
		}
		else {
			driver.findElement(By.partialLinkText("«· ›÷Ì·« ")).click();
		}
	}
	
	public static void click_Compose () {
		driver.findElement(By.cssSelector("i.fa.fa-pencil.fa-lg")).click();
	}
	
	public static void fill_Title (String title) {
		driver.findElement(By.id("txtTitle")).sendKeys(title);
	}
	
	public static void select_Tag_1 () {
		Select tag1 = new Select (driver.findElement(By.id("Classifications_FirstLevel")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
		List <WebElement> tag1Options = tag1.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(tag1Options.size());
		///////////////////
		tag1.selectByIndex(r);
	}
	
	public static void select_Tag_2 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (driver.findElement(By.id("Classifications_SecondLevel")).isDisplayed()) {
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			Select tag2 = new Select (driver.findElement(By.id("Classifications_SecondLevel")));
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////////
			tag2.selectByIndex(r);
		}
	}

	public static void select_tag_3 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (driver.findElement(By.id("Classifications_ThirdLevel")).isDisplayed()) {
			Select tag2 = new Select (driver.findElement(By.id("Classifications_ThirdLevel")));
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////
			tag2.selectByIndex(r);
		}
	}
	
	public static void select_Tag_4 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (driver.findElement(By.id("Classifications_FourthLevel")).isDisplayed()) {
			Select tag2 = new Select (driver.findElement(By.id("Classifications_FourthLevel")));
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////////////
			tag2.selectByIndex(r);
		}
	}
	
	public static void select_Category () {
		driver.findElement(By.cssSelector("div.chosen-container.chosen-container-multi")).click();
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
		List <WebElement> categoryOptions = driver.findElements(By.xpath("//*[@id=\"Category_chosen\"]/div/ul"));
		Random rand = new Random();
		int r = rand.nextInt(categoryOptions.size());
		////////////////////
		categoryOptions.get(r).click();

	}
	
	public static void select_Event () {
		Select Event = new Select (driver.findElement(By.id("ddlEvent")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
		List <WebElement> eventOptions = Event.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(eventOptions.size());
		/////////////////////
		Event.selectByIndex(r);
	}
	
	public static void select_Task () {
		Select Task = new Select (driver.findElement(By.id("ddlEventTask")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly 
		List <WebElement> taskOptions = Task.getOptions();
		if (taskOptions.size()!= 0) {
		Random rand = new Random();
		int r = rand.nextInt(taskOptions.size());
		/////////////////
		Task.selectByIndex(r);
		}
	}
	
	public static void fill_Body (String body) {
		//We used action class to focus on the Body since its not a normal textbox 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("cke_1_contents")));
		action.click();
		action.sendKeys(body);
		action.build().perform();
	}

	public static void upload_Attachment (String filePath) throws AWTException{
		//Click on attachment button to display attachment box.
		driver.findElement(By.id("btnAttachments")).click();
		//click on attachment box to open brows window.
		driver.findElement(By.id("dropzoneForm")).click();;
		
		//put the path of you file in clipboard.
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Use Robot class to simulate keyboard actions
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void send_News (String Contact){
		//click on send button to open contacts list
		driver.findElement(By.id("btn-toggle-tasks-list")).click();
		//select the contact by sending its name.
		driver.findElement(By.linkText(Contact)).click();
	}
	
	public static void fill_Note(String note){
		//click on Note button to open note text box.
		driver.findElement(By.id("btnNotes")).click();
		//fill the note by passing note parameter.
		driver.findElement(By.id("Notes")).sendKeys(note);
	}
	
	public static void save_News () {
		driver.findElement(By.id("btnSaveHeader")).click();
	}
	
	public static void discard_News () {
		driver.findElement(By.id("btnDiscardHeader")).click();
	}
	
	public static void selectAll () {
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__selectall_icon")).click();
	}
	
	public static void cut () {
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__cut_icon")).click();
	}
	
	public static void copy() {
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__copy_icon")).click();
	}
	
	public static void paste() throws AWTException{
		//Click on Paste button in Editing bar
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__pastetext_icon")).click();
		
		//Use Robot class to simulate keyboard actions to paste the copied text (CTRL+V)
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//Click on OK button
		driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_ok")).click();
	}
	
	public static void undo() {
		driver.findElement(By.className("span.cke_button_icon.cke_button__undo_icon")).click();
	}
	
	public static void redo() {
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__redo_icon")).click();
	}
	
	public static void find(String findWhat) {
		//click on Find button in Editing bar
		driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__find_icon")).click();
		//fill find textbox with required value
		driver.findElement(By.cssSelector("input.cke_dialog_ui_input_text")).sendKeys(findWhat);
		//click on Find button
		driver.findElement(By.cssSelector("a.cke_dialog_ui_button[title=Find]")).click();
		//Close Find window
		driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
	}
	
	public static void leftAlign () {
		driver.findElement(By.id("cke_25")).click();
	}
	
	public static void rightAlign () {
		driver.findElement(By.id("cke_26")).click();
	}
	
	public static void insertSeparator () {
		driver.findElement(By.id("cke_29")).click();
	}
	
	public static void replace (String find, String replace) {
		//click on replace button from Editing bar.
		driver.findElement(By.id("cke_21")).click();
		//fill find and replace text fields with required values
		driver.findElement(By.id("cke_76_textInput")).sendKeys(find);
		driver.findElement(By.id("cke_85_textInput")).sendKeys(replace);
		//click on replace all button
		driver.findElement(By.id("cke_91_label")).click();
		//wait until alert window is displayed then accept it
		WebDriverWait wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//close replace window
		driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
	}

	public static void publishToTwitter (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		driver.findElement(By.cssSelector("label.onoffswitch-label[for=TwitterEnable]")).click();
		//Fill the required text to be published
		driver.findElement(By.id("TwitterSummary")).sendKeys(whatToShare);
	}
	
	public static void publishToFacebook (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		driver.findElement(By.cssSelector("label.onoffswitch-label[for=FacebookEnable]")).click();
		//Fill the required text to be published
		driver.findElement(By.id("facebooksummary")).sendKeys(whatToShare);
	}
	
	public static void publishToYoutube (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		driver.findElement(By.cssSelector("label.onoffswitch-label[for=YoutubeEnable")).click();
		//Fill the required text to be published
		driver.findElement(By.id("youtubeSummary")).sendKeys(whatToShare);
	}
	
	public static void publishToInstagram (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		driver.findElement(By.cssSelector("label.onoffswitch-label[for=InstagramEnable")).click();
		//Fill the required text to be published
		driver.findElement(By.id("InstagramSummary")).sendKeys(whatToShare);
	}
	
	public static void selectModule (String moduleName) {
		//If you want to open a screen inside an already expanded module, first web driver will click the module 
		//so it will be collapsed, Therefore web driver will not be able to locate the screen inside this module.
		//So we found that all Modules are in tag of type <li> and the expanded module will has 
		//extra attribute called <class> with value "active" --> <li class="active">.
		//So we will check if Module element has a parent tag with <class="active"> we will pass clicking on it.
		
		//We locate the side menu element that has all the Modules.
		WebElement sideMenu = driver.findElement(By.id("side-menu"));
		//Then located the selected Module that you want to click inside the side menu element. 
		WebElement module = sideMenu.findElement(By.xpath("//span[@class='nav-label' and contains(text(), '"+moduleName+"')]"));
		//Then located the parent of the module element which is tag of type <a>
		WebElement parent = module.findElement(By.xpath(".."));
		//Then locate the parent of <a> tag element which is <li> element
		WebElement parent2 = parent.findElement(By.xpath(".."));
		//check if <li> tag does not has an attribute <class> with the value "active" we will click on it.
		if (!parent2.getAttribute("class").equals("active")) {
			driver.findElement(By.xpath("//span[@class='nav-label' and contains(text(), '"+moduleName+"')]")).click();
		}
	}
	
	public static void selectScreen (String screenName){
		//Note that find by linkText is case sensitive
		driver.findElement(By.linkText(screenName)).click();
	}
	
	public static void selectWorkflowScreen (String workflowScreen) {
		driver.findElement(By.xpath("//label[@class='center-block m-t-xs' and contains(text(), '"+workflowScreen+"')]")).click();
	}
	
	public static void selectAgencyScreen (String agencyScreen) {
		driver.findElement(By.xpath("//label[@class='center-block' and contains(text(), '"+agencyScreen+"')]")).click();
	}
	
	public static void changeLanguage (String language) {
		Select languageList = new Select(driver.findElement(By.id("LanguageID")));
		switch (language) {
		case "English":
		case "english":
			languageList.selectByIndex(0);
			break;
		case "Arabic":
		case "⁄—»Ì":
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
		Select HomePage = new Select(driver.findElement(By.id("DefaultHomePage")));
		WebElement options = HomePage.getFirstSelectedOption();
		if(options.getAttribute("value").equals("0")) {
			HomePage.selectByIndex(1);
		}
		else {
			HomePage.selectByIndex(0);
		}
	}
	
	
	public static void changeEditorialHomeScreen () {
		Select screens = new Select (driver.findElement(By.id("WebPreferredScreenID")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	
	public static void changeMobileHomeScreen () {
		Select screens = new Select (driver.findElement(By.id("PreferredScreenID")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	
	public static void changeListFontSize () {
		Select screens = new Select (driver.findElement(By.id("lsListFontSize")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	
	public static void changeEditorFontSize () {
		Select screens = new Select (driver.findElement(By.id("lsNewsFontSize")));
		List<WebElement> screensOptions = screens.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(screensOptions.size());
		screens.selectByIndex(r);
	}
	
	
	public static void changeDataeFormat (String format, String customDate) {
		Select dateFormat = new Select (driver.findElement(By.id("lsDateTimeFormat")));
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
			driver.findElement(By.id("txtCustomDateTime")).clear();
			driver.findElement(By.id("txtCustomDateTime")).sendKeys(customDate);
			break;
		}
	}
	
	public static void changeCalendarType (String calendar) {
		Select calendarTypes = new Select(driver.findElement(By.id("lsCalendarType")));
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
		driver.findElement(By.id("UserName")).clear();
		driver.findElement(By.id("UserName")).sendKeys(newUsername);
	}
	
	public static void changeEmail (String email) {
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
	}
	
	public static void changeMobile (String mobileNumber) {
		driver.findElement(By.id("Mobile")).clear();
		driver.findElement(By.id("Mobile")).sendKeys(mobileNumber);
	}
	
	public static void changePassword (String currentPassword, String newPassword, String confirmNewPassword) {
		driver.findElement(By.id("Password")).sendKeys(currentPassword);
		driver.findElement(By.id("NewPassword")).sendKeys(newPassword);
		driver.findElement(By.id("ConfirmingPassword")).sendKeys(confirmNewPassword);
	}
	
	public static void cancelPreferences () {
		driver.findElement(By.xpath("//*[@id=\"frmPreferences\"]/div[22]/div/button[1]")).click();
	}
	
	public static void savePreferences () {
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}
	
}