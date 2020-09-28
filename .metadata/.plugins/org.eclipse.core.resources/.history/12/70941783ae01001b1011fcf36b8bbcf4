package stepImplementations;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SelectPage;
import pages.ItemPage;
public class BDDCartTest {
	String priceEle ="span[class*='a-color-price']";
	String itemAdd = "input[id='add-to-cart-button']";
	String itemAdd2 = "div#addToCart_263333_feature_div span.a-button.a-spacing-small.a-button-primary.a-button-icon";


	WebDriver driver = BDDSearchTest.driver;
	ItemPage itemPage = new ItemPage(driver);
	SelectPage selectPage = new SelectPage(driver);
	
	
	@Given("^user is on selected item page$")
public void user_is_on_selected_item_page(){
		 Assert.assertTrue("User is on selected item page", itemPage.onSelectedItemPage());
		}

	
	@When("^user selects add to cart$")
public void user_enters_search_item(){
		if(itemPage.addToCart(itemAdd, itemAdd2))
		System.out.println ("User adds item to cart");
		else System.out.println ("User not able to add to cart");

}
	
	@Then("^user prints item amount$")
public void user_gets_search_results(){
		String price="";
		price = itemPage.getPrice(priceEle);
		System.out.println ("Cart Total = " + price);
		Assert.assertTrue("Fails due to not able to add to cart",itemPage.getAddedToCart());
		driver.close();
	}
	
	
}
