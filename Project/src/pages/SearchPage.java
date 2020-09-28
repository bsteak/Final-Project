package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	String item;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void searchItem(String item){
		this.item = item;
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);
		driver.findElement(By.id("twotabsearchtextbox")).submit();;
		
	}
	
	public boolean onSearchPage(){
		boolean found = false;
		found = driver.findElement(By.name("site-search")).isDisplayed();
		
		return found;	
	}
	
	public boolean foundItem(){
		String itemList ="";
	    try {
	         // identify element
	    	WebElement items = driver.findElement(By.cssSelector(".a-section"));
	         // Explicit wait condition for visibility of element
	         WebDriverWait w = new WebDriverWait(driver, 5);
	         w.until(ExpectedConditions .visibilityOfElementLocated(By.cssSelector((".a-section"))));
	 		itemList = items.getText();
	      }
	      catch(NoSuchElementException n) {
	         return false;
	      }
		return itemList.contains("1");
	}
}
