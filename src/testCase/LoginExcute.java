package testCase;

import org.openqa.selenium.WebDriver;
import config.ActionKeywords;
import config.Home;
import config.LoginPage;
import config.Preferences;

public class LoginExcute {
	public static WebDriver driver;
	public static void main (String[] args)throws Exception{

		ActionKeywords.openBrowser("chrome");
		ActionKeywords.navigate();
		LoginPage.input_Username("mays");
		LoginPage.input_Password("123");
		Home.click_User();
		Home.click_Preferences();
		Preferences.changeLanguage("English");
		//Preferences.changeDefaultHomePage();
		//Preferences.changeDateFormat(" Œ’Ì’", "dd/MM/yyyy hh:mm:ss");
		//Preferences.changeCalendarType("hijri");
		Preferences.changePassword("test", "newPass", "ConfirmPass");
		Preferences.changeMobile("13");
		Preferences.changeEmail("");
		//Preferences.changeUsername("test");
		//Preferences.changePassword("test", "newPass", "ConfirmPass");
		Preferences.cancelPreferences();
		ActionKeywords.waitFor(30);
		ActionKeywords.closeBrowser();

		}
	}