package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTheresaPage extends BasePage{
	
	
	//Creating locators for the MyTheresa Page elements
	String genderCategory = "//a[@title='{0}']/parent::li";
	
	String category = "//li[contains(@class,'level0') and not(contains(@class, 'hidden'))]/a[@title='{0}']";
	
	@FindBy(xpath = "//div[@class='big-teaser-full']")
	WebElement bigTeaser;
	
	@FindBy(id = "myaccount")
	WebElement myAccount;
	
	@FindBy(xpath = "//div[@class='content fieldset']//input[@id='email']")
	WebElement emailID;
	
	@FindBy(xpath = "//div[@class='content fieldset']//input[@title='Password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//div[@id='qa-login-button']/button")
	WebElement loginButton;
		
	@FindBy(xpath = "//div[@data-grid-v3='grid'][contains(@class,'cart')]//span[@data-zta='articlePrice']")
	List<WebElement> singleQuanityProductPricesInCart;
	
	@FindBy(xpath = "//div[@class='col2-set']//p[contains(text(),'Name')]")
	WebElement accountInfoName;
	
	@FindBy(xpath = "//div[@class='col2-set']//p[contains(text(),'E-mail')]")
	WebElement accountInfoEmail;
	
	@FindBy(xpath = "//div[@class='col2-set']//a[text()='Edit']")
	WebElement accountInfoEdit;

	@FindBy(xpath = "//div[@class='col2-set']//a[text()='Change Password']")
	WebElement accountInfoChangePwd;

	
	//creating constructor for the class file
	public MyTheresaPage(WebDriver driver) {
		super(driver);
		
	}
	
	/**
	 * This method is to get the status code on launching the MyTheresa Page
	 * @throws IOException, MalformedURLException 
	 * @returns response code
	 */
	public int validateTheResponseCodeOnLaunchingPage() throws MalformedURLException, IOException {
		
		String strUrl = driver.getCurrentUrl();
		
		System.out.println("Response code: "+getResponseCode(strUrl));
	    return getResponseCode(strUrl);
		
	}
	
	/**
	 * This method is to get the title on launching the MyTheresa page
	 * @returns title of the page
	 */
	public String getTitleOnPage() {
		
		return driver.getTitle();
		
	}
	
	/**
	 * This method is to verify the gender category selected
	 * @returns the status of the category selected
	 * @param gender category which is selected
	 */
	public String getGenderCategoryStatusSelection(String gender) {
		
		String status = getAttributeFromWebElement(driver.findElement(By.xpath(genderCategory.replace("{0}", gender))), "class");
		
		return status;
		
	}
	
	/**
	 * This method is to get all the links available on MyTheresa page
	 * @returns all the list of URLs available
	 */
	public List<String> getAllTheLinksInTheWebPage() {
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		List<String> urls = new ArrayList<>();
		
		//Traversing through the list and printing its text along with link address
		 for(WebElement link:allLinks) {
			 
			 if((link.getAttribute("href")!=null) && !(link.getAttribute("href").contains("javascript")) && (link.getAttribute("href")!="")) {
				 urls.add(link.getAttribute("href"));
			 }
		 
		 }
		 
		return urls;
		
	}
	
	/**
	 * This method is to get response code for specific URL
	 * @throws IOException, MalformedURLException 
	 * @param URL for which we are getting the response
	 * @returns response code
	 */
	public int validateResponseCodeForSpecificURL(String url) throws MalformedURLException, IOException {
		
		System.out.println("Response code: "+getResponseCode(url));
	    return getResponseCode(url);
		
	}
	
	/**
	 * This method is to click on my account button
	 */
	public void clickOnMyAccountBtn() {
		
		waitForElementToBeClickable(myAccount);
		clickOnWebElement(myAccount);
		
	}
	
	/**
	 * This method is to enter email id to the input field
	 * @param email
	 */
	public void enterEmailId(String email) {
		
		waitForElementToBeClickable(emailID);
		enterTextToWebElement(emailID, email);
		
	}
	
	/**
	 * This method is to enter password to the input field
	 * @param password
	 */
	public void enterPassword(String password) {
		
		waitForElementToBeClickable(passwordField);
		enterTextToWebElement(passwordField, password);
		
	}
	
	/**
	 * This method is to click on login button
	 * @throws InterruptedException 
	 */
	public void clickOnLoginBtn() throws InterruptedException {	

		waitForElementToBeClickable(loginButton);
		Thread.sleep(3000);
		clickOnWebElement(loginButton);
		
	}
	
	/**
	 * This method is to get the name from account info
	 * @returns account name as String
	 */
	public String getNameFromAccountInfo() {
		
		return getTextFromAnWebElement(accountInfoName);
		
	}
	
	/**
	 * This method is to get the email from account info 
	 * @returns email as String
	 */
	public String getEmailFromAccountInfo() {
		
		return getTextFromAnWebElement(accountInfoEmail);
		
	}
	
	/**
	 * This method is to verify the availability of edit button
	 * @returns boolean value based on availability of element
	 */
	public boolean verifyAvailabilityOfEditBtn() {
		
		return verifyIsElementDisplayed(accountInfoEdit);
		
	}
	
	/**
	 * This method is to verify the availability of change password button
	 * @returns boolean value based on availability of element
	 */
	public boolean verifyAvailabilityOfChangePwdBtn() {
		
		return verifyIsElementDisplayed(accountInfoChangePwd);
		
	}
}
