package testCase;

import config.ActionKeywords;
import config.Home;
import config.LoginPage;
import config.Screen;


public class TestConfirmationMessage {
	
	public static void main (String[] args) throws Exception{
		ActionKeywords.openBrowser("chrome");
		ActionKeywords.navigate("http://10.0.10.71/SEDCOWebServer/");
		LoginPage.input_Username("root");
		LoginPage.input_Password("root");
		Home.selectModule("Basket");
		Home.selectScreen("My Documents");
		Screen.Select_Item();
		Screen.Select_News();
		Screen.Open_Tasks();
		Screen.Select_Task("");
		ActionKeywords.closeBrowser();
	}

}
