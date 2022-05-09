package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private static final int TIMEOUT = 15;
    private static final int POLLING = 1000;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new  WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
     
    }

    protected void waitForPageURLToLoad(String url) {
    	wait.until(ExpectedConditions.urlContains(url));
    }
    
    protected void waitForElementToBeClickable(WebElement locator) {
    	
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected void waitForElementToAppear(WebElement locator) {
        
    	wait.until(ExpectedConditions.visibilityOf(locator));
         
    }

    protected void waitForElementToDisappear(WebElement locator) {
    	
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void waitForTextToDisappear(WebElement locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(locator, text)));
    }
    
    protected boolean verifyIsElementDisplayed(WebElement locator) {
    	
    	waitForElementToAppear(locator);
    	return locator.isDisplayed();
    }
    
    protected boolean verifyIsElementEnabled(WebElement locator) {
    	return locator.isEnabled();
    }

    protected void clickOnWebElement(WebElement locator) {
    	
    	locator.click();
    }
    
    protected void enterTextToWebElement(WebElement locator, String text) {
    	
    	locator.clear();
    	locator.sendKeys(text);
    }
    
	protected String getTextFromAnWebElement(WebElement locator) {
    	
    	return locator.getText();
    }
	
	
	protected int getResponseCode(String url) throws MalformedURLException, IOException {
    	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		HttpURLConnection connect= (HttpURLConnection)new URL(url).openConnection();
		
		connect.setRequestMethod("HEAD");
		
		connect.connect();
		
	    return connect.getResponseCode();
    }
	
	protected String getAttributeFromWebElement(WebElement locator, String attribute) {

    	return locator.getAttribute(attribute);
    }
	

	
}
