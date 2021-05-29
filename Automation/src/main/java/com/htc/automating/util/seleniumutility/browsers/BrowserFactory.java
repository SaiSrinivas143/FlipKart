package com.htc.automating.util.seleniumutility.browsers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class BrowserFactory {
	
	public static WebDriver getDriver(String browser) throws MyException{
		WebDriver driver=null;
		try {
			if(browser!=null)
				if(browser.equalsIgnoreCase("chrome")) {
					System.setProperty(GlobalVariables.CHROME_DRIVER, GlobalVariables.CHROME_DRIVER_PATH);
					ChromeOptions options = new ChromeOptions();
					options.setCapability("browser", "chrome");
					options.setCapability("platform", "windows");
					Map<String,Object> prefs = new HashMap<String,Object>();
					prefs.put("credentials_enabled_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
//					driver= new RemoteWebDriver(new URL(GlobalVariables.Hub_Url), options);
					driver= new ChromeDriver(options);
					Loggers.info(BrowserFactory.class.getName(), "Got Chrome Driver");
				}
				
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty(GlobalVariables.GECKO_DRIVER, GlobalVariables.GECKO_DRIVER_PATH);
					driver= new FirefoxDriver();
					Loggers.info(BrowserFactory.class.getName(), "Got Firefox Driver");
				}
				else if(browser.equalsIgnoreCase("edge")) {
					System.setProperty(GlobalVariables.EDGE_DRIVER, GlobalVariables.EDGE_DRIVER_PATH);
					driver= new EdgeDriver();
					Loggers.info(BrowserFactory.class.getName(), "Got Microsoft Edge Driver");
				}
				else if(browser.equalsIgnoreCase("IE")) {
					System.setProperty(GlobalVariables.IE_DRIVER, GlobalVariables.IE_DRIVER_PATH);
					InternetExplorerOptions options = new InternetExplorerOptions();
					options.setCapability("credentials_enabled_service", false);
					options.setCapability("profile.password_manager_enabled", false);
					driver= new InternetExplorerDriver(options);
					Loggers.info(BrowserFactory.class.getName(), "Got IE Driver");
				}
				else {
					Assert.assertTrue(false, "No browser found to launch");
				}
			else
				throw new MyException("Browser is null");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("unable to find required browser");
		}
		return driver;
	}
}