package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;

import com.mytheresa.factory.DriverFactory;

import pages.MyTheresaPage;

public class MyTheresaTest {

	private MyTheresaPage mytheresaPage = new MyTheresaPage(DriverFactory.getDriver());

	/**
	 * This method is to validate the MyTheresa page loaded successfully
	 * @throws IOException, MalformedURLException 
	 */
	public void verifyPageLoadedSuccessfullyTest() throws MalformedURLException, IOException {
		
		Assert.assertEquals("Status code should be correct", 200 , mytheresaPage.validateTheResponseCodeOnLaunchingPage());

		String title = mytheresaPage.getTitleOnPage();
		System.out.println("Title "+title);
		Assert.assertTrue("Title of the page should be correct", title.contains("Luxury Fashion & Designer Shopping"));

	}

	/**
	 * This method is to get all the available links in the MyTheresa page
	 * @throws IOException, MalformedURLException 
	 */
	public void getAllAvailableLinksInPageTest() throws MalformedURLException, IOException {
		
		List<String> listOfURLs = mytheresaPage.getAllTheLinksInTheWebPage();
		System.out.println("Urls list size: "+listOfURLs.size());
		for(int i=0; i<listOfURLs.size(); i++) {
			System.out.println("Url at index "+i+ " is: "+listOfURLs.get(i));
			
			if(listOfURLs.get(i).startsWith("https:"))
			{
				try {
					Assert.assertTrue("Status code should be correct", mytheresaPage.validateResponseCodeForSpecificURL(listOfURLs.get(i))==200 || 
							String.valueOf(mytheresaPage.validateResponseCodeForSpecificURL(listOfURLs.get(i))).equals("/^30[0-9]?$/"));
				}
				catch(AssertionError e) {
					System.out.println("Failed Assertion for URL: "+listOfURLs.get(i)+ " and response code is:"+mytheresaPage.validateResponseCodeForSpecificURL(listOfURLs.get(i)));
				}
			}
				
		}
	} 
	
	/**
	 * This method is to validate the gender category selected under MyTheresa page
	 * @param - gender category which is selected
	 */
	public void verifyGenderCategorySelectedTest(String gender) {
		
		Assert.assertTrue("Status code should be correct", mytheresaPage.getGenderCategoryStatusSelection(gender).contains("active"));

	}
	
	/**
	 * This method is to click on my account button under MyTheresa page
	 */
	public void clickOnMyAccountTest() {
		
		mytheresaPage.clickOnMyAccountBtn();

	}
	
	/**
	 * This method is to logging to the account under MyTheresa page
	 * @param - email and password to enter in to the input fields
	 * @throws InterruptedException 
	 */
	public void loginToTheAccountTest(String email, String password) throws InterruptedException {
		
		mytheresaPage.enterEmailId(email);
		mytheresaPage.enterPassword(password);
		mytheresaPage.clickOnLoginBtn();

	}
	
	/**
	 * This method is to validate the account info after logging into the account
	 * @param - name of the account, email id with which we logged in
	 */
	public void verifyAccountInfoOnLoginTest(String name, String email) {
		
		Assert.assertTrue("Name should be correct", mytheresaPage.getNameFromAccountInfo().contains(name));
		Assert.assertTrue("Email should be correct", mytheresaPage.getEmailFromAccountInfo().contains(email));
		Assert.assertTrue("Edit button should be displayed", mytheresaPage.verifyAvailabilityOfEditBtn());
		Assert.assertTrue("Change password button should be displayed", mytheresaPage.verifyAvailabilityOfChangePwdBtn());

	}

}
