import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
public class SeleniumConfig {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bsalisbury/Documents/TRAINING/QE LD Academy Automation Testing/chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Launch Webdriver
		driver.get("https://www.facebook.com/");//Navigate to website
		//driver.findElement(By.id("searchButton")).click();
		driver.findElement(By.className("uiButton")).click();
		
	}

}
