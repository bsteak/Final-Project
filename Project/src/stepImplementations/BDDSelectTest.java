package stepImplementations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import pages.SearchPage;
import pages.SelectPage;

public class BDDSelectTest {
	WebDriver driver = BDDSearchTest.driver;
	SelectPage selectPage = new SelectPage(driver);
	SearchPage searchPage = new SearchPage(driver);
	String selectItem = "//*[@data-image-index='10']";

	@Given("^user is on results page$")
	public void user_is_on_results_page() {
		if(searchPage.foundItem())
	System.out.println ("User is on the results page");
	
}


	@And("^user finds item$")
public void user_finds_item(){
		if(selectPage.findItem(selectItem)){
			
	System.out.println ("User finds 10th item");
		}
}
	
	@When("^user prints item rating$")
public void user_prints_item_ratings(){
		selectPage.selectItemRating();
	}
	
	@Then("^user selects item$")
		public void user_selects_item(){
		
		//selectPage.selectItem();
		Assert.assertTrue("User did select 10th item", selectPage.selectItem(selectItem));
			
		}
	
}