package testCase;

import config.ActionKeywords;
import config.Home;
import config.LoginPage;
import config.Screen;

public class LoginExcute {
	
	public static void main (String[] args)throws Exception{
		
		try {
		ActionKeywords.openBrowser("chrome");
		ActionKeywords.navigate("http://10.0.10.71/SEDCOWebServer");
		ActionKeywords.waitFor(3);
		LoginPage.input_Username("root");
		LoginPage.input_Password("root");
		Home.selectModule("Baskets");
		Home.selectScreen("My Documents");
		Screen.DateFilter();
		ActionKeywords.waitFor(5);
		ActionKeywords.driver.quit();
		}
		finally {
			System.out.println("finally");
			ActionKeywords.driver.quit();
		}
		}
	}