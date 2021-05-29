package com.htc.automating.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.pages.AddressPage;
import com.htc.automating.pages.AppDownloadPage;
import com.htc.automating.pages.CartPage;
import com.htc.automating.pages.HomePage;
import com.htc.automating.pages.LogInPage;
import com.htc.automating.pages.MyProfilePage;
import com.htc.automating.pages.OrderSummaryPage;
import com.htc.automating.pages.ProductDetailsPage;
import com.htc.automating.pages.TravelPage;
import com.htc.automating.util.javautility.MyException;
import com.htc.automating.util.seleniumutility.browsers.BrowserFactory;
import com.htc.automating.util.seleniumutility.extentreports.ExtentHtmlReport;
import com.htc.automating.util.seleniumutility.screenshots.ScreenShots;

public class BaseTest{
	
	public static WebDriver driver;
	protected static LogInPage login;
	protected static ProductDetailsPage product;
	protected static CartPage cartpage;
	protected static HomePage home;
	protected static AddressPage address;
	protected static MyProfilePage profile; 
	protected static OrderSummaryPage order;
	protected static AppDownloadPage download;
	protected static TravelPage tpage;
	protected static ExtentReports extent =ExtentHtmlReport.getInstance();
	protected static ExtentTest test;
	protected static ExtentTest parent;
	protected static ExtentTest child;
	protected ScreenShots shot;
	
	@BeforeSuite
	@Parameters("browser")  
	public void setup(String browser) {
		try {
			driver  = BrowserFactory.getDriver(browser);
			getUrl();
			driver.manage().window().maximize();
			Reporter.log(" Window maximized ");
			login    = new LogInPage(driver);
			product  = new ProductDetailsPage(driver);
			cartpage = new CartPage(driver);
			home     = new HomePage(driver);
			tpage    = new TravelPage(driver);
			address  = new AddressPage(driver);
			profile  = new MyProfilePage(driver);
			download = new AppDownloadPage(driver);
			order    = new OrderSummaryPage(driver);
			driver.manage().timeouts().implicitlyWait(GlobalVariables.TIMEOUT_TIME, TimeUnit.SECONDS);
		}catch(MyException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		Reporter.log("driver closed ");
	}
	
	@AfterMethod
	public void Logout() {
		try {
			login.doLogOut();
			child=parent.createNode(" Logout is success ");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	public void getUrl() throws MyException {
		try {
			driver.get(GlobalVariables.URL);
			Reporter.log("Open "+GlobalVariables.URL);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}