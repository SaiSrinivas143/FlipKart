package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.AppDownloadPageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class AppDownloadPage extends BasePage implements AppDownloadPageObjects{

	public AppDownloadPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean downloadApp() throws MyException {
		boolean flag=false;
		try {
			clickOnElement(webElement(googleplaystore));
			switchToWindow(1);
			flag=getTitle().contains("Google Play");//Flipkart Online Shopping App - Apps on Google Play
			Loggers.info(AppDownloadPage.class.getName(), "Opens the google play store page");
			Reporter.log("Checking for app is downloadable "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	

}
