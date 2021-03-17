package com.htc.automating.base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.pages.CheckoutPage;
import com.htc.automating.pages.LogInPage;
import com.htc.automating.pages.ProductOrderPage;
import com.htc.browsers.BrowserFactory;

public class BaseTest extends GlobalVariables{
	
	public static WebDriver driver;
	protected static LogInPage login;
	protected static ProductOrderPage order;
	protected static CheckoutPage checkout;
	
	@BeforeSuite
	@Parameters("browser")  
	public void setup(String browser) {
		driver= BrowserFactory.getDriver(browser);
		driver.get(URL);
		driver.manage().window().maximize();
		login=new LogInPage();
		order= new ProductOrderPage();
		checkout =new CheckoutPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
