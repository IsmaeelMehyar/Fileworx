package appModule;

import pageObjects.PreferencesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class PreferencesAction {
	public static void Execute (WebDriver driver) {
		
		
		//Change Preferred Language
		Select prefLanguage = new Select (PreferencesPage.preferredLanguage(driver));
		WebElement option = prefLanguage.getFirstSelectedOption();
		if (option.getText().equals("English")) {
			prefLanguage.selectByVisibleText("ÚÑÈí");
		}
		
		else {
			prefLanguage.selectByVisibleText("English");
		}
		// End of Change Preferred Language
		
		//****************************************************************
		
		// Change Mobile Application Home Screen to a random screen.
		Select mobileHomeScreen = new Select (PreferencesPage.mobileHomeScreen(driver));
		List <WebElement> options2 = mobileHomeScreen.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(options2.size())+ 1;
		mobileHomeScreen.selectByIndex(r);
		//End of Changing mobile application home screen.
		
		
	}

}
