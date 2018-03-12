package appModule;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utility.ExcelUtil;

public class LoginAction {
	public static void Excute(WebDriver driver) throws Exception  {
		
		
		//String username= ExcelUtil.getCellValue(1, 1);
		//String password= ExcelUtil.getCellValue(1, 2);
		LoginPage.userName(driver).sendKeys("root");
		LoginPage.password(driver).sendKeys("root");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginBtn(driver)));
		LoginPage.loginBtn(driver).click();
		
	}

}
