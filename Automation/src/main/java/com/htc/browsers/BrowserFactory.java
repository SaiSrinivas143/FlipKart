package com.htc.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.htc.automating.globalvariables.GlobalVariables;

public class BrowserFactory {
	
	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(GlobalVariables.CHROME_DRIVER, GlobalVariables.CHROME_DRIVER_PATH);
			driver= new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(GlobalVariables.GECKO_DRIVER, GlobalVariables.GECKO_DRIVER_PATH);
			driver= new FirefoxDriver();
		}
		else {
			Assert.assertTrue(false, "No browser found to launch");
		}
		return driver;
	}

}
