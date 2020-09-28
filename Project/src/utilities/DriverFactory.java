package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType){
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "c:..\\geckodriver.exe");
			return new FirefoxDriver();
		}
			else {
				System.setProperty("webdriver.chrome.driver", "c:..\\chromedriver.exe");
				return new ChromeDriver();
			
		}
	}
	
	

}
