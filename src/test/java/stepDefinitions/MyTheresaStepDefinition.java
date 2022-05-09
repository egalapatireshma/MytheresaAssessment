package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.MyTheresaTest;
public class MyTheresaStepDefinition {

	private MyTheresaTest mytheresaTest = new MyTheresaTest();

	@Given("^Launch mytheresa page and validate page loaded successfully$")
	public void launchPage() throws MalformedURLException, IOException {
		System.out.println("In the Launch page method");
		mytheresaTest.verifyPageLoadedSuccessfullyTest();
	}
	
	@Then("^User validates (.*) is selected under gender categories$")
	public void validateGenderCategorySelected(String gender) {
		System.out.println("Inside the verification of gender category selected method");
		mytheresaTest.verifyGenderCategorySelectedTest(gender);
	}
	
	@And("^User gets all the links available in the web page and validates response codes$")
	public void getAllLinksInWebPage() throws MalformedURLException, IOException {
		System.out.println("Inside the verification of links and response codes method");
		mytheresaTest.getAllAvailableLinksInPageTest();
	}


	@When("^User clicks on my account button$")
	public void clickOnMyAccount() {
		System.out.println("Inside the clicking of my account method");
		mytheresaTest.clickOnMyAccountTest();

	}

	@And("^User enters (.*) and (.*) to login$")
	public void loginToTheAccount(String email, String password) throws InterruptedException {
		System.out.println("Inside the logging into the account method");
		mytheresaTest.loginToTheAccountTest(email, password);

	}
	
	@Then("^User validates the (.*) and (.*) login information$")
	public void validateAccountInformationt(String name, String email) {
		System.out.println("Inside the validation of account information on login method");
		mytheresaTest.verifyAccountInfoOnLoginTest(name, email);

	}
	
}
