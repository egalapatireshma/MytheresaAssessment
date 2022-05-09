package appHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mytheresa.factory.DriverFactory;
import com.mytheresa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() throws IOException {
		
		configReader = new ConfigReader();
		prop = configReader.init_property();
	
	}
	
	@Before(order = 1)
	public void launchBrowser() {
	
		String browser = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);
		
		String env = prop.getProperty("environment");
		
		String url;
		if(env.equalsIgnoreCase("staging")) {
			url = prop.getProperty("stagingurl");
			driver.get(url);
		}
		else if(env.equalsIgnoreCase("local")) {
			url = prop.getProperty("localURL");
			driver.get(url);
		}
		else if(env.equalsIgnoreCase("test")) {
			url = prop.getProperty("testURL");
			driver.get(url);
		}
		else if(env.equalsIgnoreCase("production")) {
			url = prop.getProperty("prodURL");
			driver.get(url);
		}

	}
	
	@After(order = 0)
	public void quitBrowser() {
		
		driver.quit();
	
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			
			//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			//To save to a specific path
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ "/target/screenshots/" + screenshotName));
		}
	
	}
}
