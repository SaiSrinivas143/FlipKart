package com.htc.automating.base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.pages.LogInPage;
import com.htc.browsers.BrowserFactory;

public class BaseTest extends GlobalVariables{
	
	protected static WebDriver driver;
	public static LogInPage login;
	
	@BeforeSuite
	@Parameters("browser")  
	public void setup(String browser) {
		//System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
		//driver = new ChromeDriver();
		driver= BrowserFactory.getDriver(browser);
		driver.get(URL);
		driver.manage().window().maximize();
		login=new LogInPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
