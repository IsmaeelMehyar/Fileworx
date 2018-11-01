package testCase;

import config.ActionKeywords;
import config.Compose;
import config.Home;
import config.LoginPage;
import config.Screen;

public class CreateNews {
	
	public static void main (String[] args) throws Exception{
		
		int count =1;
		int maxTries =5;
		boolean fail= true;
		do {
			try {
				ActionKeywords.openBrowser("chrome");
				ActionKeywords.navigate("http://10.0.10.71/SEDCOWebServer/");
				LoginPage.input_Username("root");
				LoginPage.input_Password("root");
				for (int i=5;i<=6;i++) {
					Home.click_Compose();
					ActionKeywords.waitFor(2);
					Compose.fill_Title("Automated test title"+i);
					Compose.fill_Body("Automated test body"+i);
					Compose.save_News();
					ActionKeywords.waitFor(2);
					Home.selectModule("Baskets");
					Home.selectScreen("My Documents");
					Screen.Select_Item();
					Screen.Select_News();
					Screen.Open_Tasks();
					Screen.Select_Task();
					Compose.fill_Title("Quote ");
					Compose.fill_Body("Quote ");
					Compose.save_News();
					ActionKeywords.waitFor(3);	
					System.out.println("news"+i);
				}
				fail = false;
			}
			
			catch (Exception e) {
				ActionKeywords.closeBrowser();
				fail= true;
				if (++count == maxTries) {
					throw e;
				}
				
			}
			finally {
				ActionKeywords.closeBrowser();
				
			}
		}while (fail && count < maxTries);
	}
}

