package pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	public String homeTitle = "Wayfair";
	
	
	public void goToCat(){
	   	
		driver.findElement(By.linkText("Furniture")).click();
	}
	
	public void goTosubCat(String subCat){
		
	    	driver.findElement(By.cssSelector(subCat)).click();		  
			}
	
	public String getTitle(){
		String title ="";
		
		title = driver.getTitle();
		System.out.println("Title is "+ title);
		return title;
		
	}

	public boolean onHomePage(){
		boolean home = false;
		getTitle().contains(homeTitle);
		return home;
			
	}
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

}
