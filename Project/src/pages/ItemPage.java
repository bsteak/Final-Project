package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemPage {
	
	//private static final String buttonEle = null;

	private WebDriver driver;

	public boolean addedToCart; //Check if item page had an add to cart button
	boolean onSelectPage = false;
	WebElement we = null;
	
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public boolean onSelectedItemPage(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#breadcrumb-back-link.a-link-normal.a-color-tertiary")));
 
		if (driver.findElement(By.cssSelector("a#breadcrumb-back-link.a-link-normal.a-color-tertiary")).getText().contains("Back to results"))
			onSelectPage = true;
		return onSelectPage;
	}
	
	
	public void addToCart(String cartEle)	{
		try {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.cssSelector(cartEle)));
		we = driver.findElement(By.cssSelector(cartEle));
		if(we.isDisplayed())we.click();
		System.out.println("Item added to cart ");
		addedToCart = true;
		}catch(Exception e){
			addedToCart = false;
		}
	}
	public boolean addToCart(String itemAdd, String itemAdd2){
		WebElement wd = null;
		try{
			
			addedToCart = driver.findElement(By.cssSelector(itemAdd)).isDisplayed();
						
		}
		catch(NoSuchElementException n1){
			try {wd = driver.findElement(By.cssSelector(itemAdd2));
			addedToCart = 	driver.findElement(By.cssSelector(itemAdd2)).isDisplayed();
			if (addedToCart) wd.click();
				return addedToCart;
				
			}
			catch(NoSuchElementException n2){
				return addedToCart;
				
			}
				}
		catch( Exception e){
			addedToCart = false;
			return addedToCart;
		}
		if (addedToCart){
			
			driver.findElement(By.cssSelector(itemAdd)).click();
			return addedToCart;
		
			}
		return addedToCart;
		
	}	
	
	public String getPrice(String priceEle){
		String price ="";
		boolean foundPrice = false;
		
      if (addedToCart){
  		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.cssSelector(priceEle)));

    	  foundPrice = driver.findElement(By.cssSelector(priceEle)).isDisplayed();
    	  if (foundPrice)
		price = driver.findElement(By.cssSelector(priceEle)).getAttribute("innerHTML");
      }
		return price;
	}
	public void getTotal(){
		// Debug
	/*	String test = driver.getCurrentUrl();
		System.out.println(test);*/
		String total = "";

		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.linkText("Review Cart")));
		we = driver.findElement(By.linkText("Review Cart"));
		if(we.isDisplayed()) we.click();
		total = driver.findElement(By.cssSelector("div.OrderSummaryTable-row.OrderSummaryTable-total span.OrderSummaryTable-cell.OrderSummaryTable-cell--right")).getAttribute("innerHTML");
		System.out.println("Total with estimated tax "+total);
	}
	
	public void clickButton(String buttonEle){
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(buttonEle)));
		we = driver.findElement(By.cssSelector(buttonEle));
		if(we.isDisplayed())we.click();
	}
	public boolean getAddedToCart(){
		return addedToCart;
		
		
	}

	public void gotoCart(String gotoCartEle){
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(gotoCartEle)));
		we = driver.findElement(By.cssSelector(gotoCartEle));
		if(we.isDisplayed())we.click();
	}

	public void delItem(String delItemEle, String delItemEle2){
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(delItemEle)));
		we = driver.findElement(By.cssSelector(delItemEle));
		if(we.isDisplayed())we.click();
		
		//Handle popover
		//a-popover-wrapper
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.cssSelector("div#a-popover-4"))));
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(delItemEle2)));
		we = driver.findElement(By.cssSelector(delItemEle2));
		if(we.isDisplayed())we.submit();
		
		System.out.println("Item(s) removed from cart");
	}
}