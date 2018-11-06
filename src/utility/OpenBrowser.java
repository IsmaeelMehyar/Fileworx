package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
	public static WebDriver driver = null;
	
	public static WebDriver openBrowser() throws Exception{
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(Constant.url);
			
			}
		catch (Exception e) {
			throw (e);
		}
		return driver;
	}

}
