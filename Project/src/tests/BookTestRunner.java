package tests;

//Practical Question 1

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",glue="stepImplementations")


public class BookTestRunner {

}
