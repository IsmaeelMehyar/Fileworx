package appModule;

import pageObjects.ComposePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;


public class ComposeNewsAction {
	public static void Execute (WebDriver driver, String body, String note) {
		
		ComposePage.title(driver).sendKeys(body);
		ComposePage.notesBtn(driver).click();
		ComposePage.notesTxt(driver).sendKeys(note);
		Select tag = new Select (ComposePage.tagLvl1(driver));
		List <WebElement> tagOptions = tag.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(tagOptions.size()-0);
		tag.selectByIndex(r);
		if (ComposePage.tagLvl2(driver).isDisplayed()) {
			Select tag2 = new Select (ComposePage.tagLvl2(driver));
			List<WebElement> tag2Options = tag2.getOptions();
			Random rand2 = new Random();
			int r2 = rand2.nextInt(tag2Options.size()-0);
			tag2.selectByIndex(r2);
		}
		//Fileworx_ComposePage.category(driver).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(ComposePage.body(driver));
		action.click();
		action.sendKeys("Body test POM");
		action.build().perform();
	}

}