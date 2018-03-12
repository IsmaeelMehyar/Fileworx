package testCase;

import org.openqa.selenium.WebDriver;
import config.ActionKeywords;

public class LoginExcute {
	public static WebDriver driver;
	public static void main (String[] args)throws Exception{

		ActionKeywords.openBrowser("chrome");
		ActionKeywords.navigate();
		ActionKeywords.input_Username("mays");
		ActionKeywords.input_Password("123");
		ActionKeywords.click_Login();
		ActionKeywords.click_User();
		ActionKeywords.click_Preferences();
		ActionKeywords.changeLanguage("Arabic");
		ActionKeywords.changeDefaultHomePage();
		ActionKeywords.changeEditorialHomeScreen();
		ActionKeywords.changeDataeFormat(" Œ’Ì’", "dd/MM/yyy hh:mm:ss");
		ActionKeywords.changeCalendarType("hijri");
		ActionKeywords.changeMobile("13");
		ActionKeywords.changeEmail("");
		ActionKeywords.changeUsername("test");
		ActionKeywords.changePassword("test", "newPass", "ConfirmPass");
		ActionKeywords.changeEditorialHomeScreen();
		ActionKeywords.cancelPreferences();
		ActionKeywords.waitFor(4);
		ActionKeywords.closeBrowser();

		}
	}