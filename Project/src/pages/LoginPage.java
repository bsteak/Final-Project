package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement we;
	WebElement username;
	WebElement password;
	WebElement login;
	String userName;
	String passWd;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public boolean getLogin(String signinEle){
	    try {
	         // identify element
	    	we = 	driver.findElement(By.cssSelector(signinEle));

	 		we.click();
	 		System.out.println("User Logging in to add to cart");
	 		return true;
	      }
	      catch(NoSuchElementException n) {
	    	  System.out.println("User Logigng in to add to cart");
	    	  return false;
	      }
	}
	
	
	
	
	
	
	public void setUserName(String user){ 
		
		 username = driver.findElement(By.cssSelector(user));
	}
	
	public void setPassWd(String passwd){
		
		 password = driver.findElement(By.cssSelector(passwd));
	}
	
	public boolean login(String usernameEle, String passwordEle){
		
		username.sendKeys(usernameEle);
		password.sendKeys(passwordEle);
		login.click();
		return true;
		
	}
	public void setLogin(String loginEle){
			
			login = driver.findElement(By.cssSelector(loginEle));
		}
	}


