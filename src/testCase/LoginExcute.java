package testCase;

import config.ActionKeywords;
import config.Home;
import config.LoginPage;
import config.Preferences;

public class LoginExcute {
	
	public static void main (String[] args)throws Exception{

		ActionKeywords.openBrowser("Firefox");
		ActionKeywords.navigate("http://10.0.10.71/SEDCOWebServer");
		LoginPage.input_Username("root");
		LoginPage.input_Password("root");
		Home.click_User();
		Home.click_Preferences();
		Preferences.changeLanguage("English");
		Preferences.changeDefaultHomePage();
		Preferences.changeDateFormat(" Œ’Ì’", "dd/MM/yyyy hh:mm:ss");
		Preferences.changeCalendarType("hijri");
		Preferences.changePassword("test", "newPass", "ConfirmPass");
		Preferences.changeMobile("13");
		Preferences.changeEmail("");
		ActionKeywords.waitFor(5);
		Preferences.cancelPreferences();
		ActionKeywords.waitFor(3);
		ActionKeywords.closeBrowser();

		}
	}