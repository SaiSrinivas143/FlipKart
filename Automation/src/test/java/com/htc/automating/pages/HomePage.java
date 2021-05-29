package com.htc.automating.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IHomePageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class HomePage extends BasePage implements IHomePageObjects{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void goToDownloadPage() throws MyException {
		try {
			javaSleep(5000);
			doubleClickOnElement(webElement(moreicon));
			clickOnElement(webElement(downloadappoption));
			Reporter.log("Went to download page ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean isTelephoneNumberCorrect() throws MyException {
		boolean flag=false;
		try {
			flag=getText(webElement(telephoneno)).equals("1800 202 9898");
			Reporter.log("Checking for Mobile number "+flag);
			Loggers.info(HomePage.class.getName(), " Is your mobile number correct "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public boolean isMyFirstNameDisplayed(String fname) throws MyException {
		boolean flag=false;
		try {
			for(WebElement name:webElements(username)) {
				if(getText(name).equals("More")) {
					
				}
				else {
					flag=getText(name).equals(fname);
				}
			}
			Reporter.log("Checking for full name displayed "+flag);
			Loggers.info(HomePage.class.getName(), " Is your first name displayed "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void clickOnUsername() throws MyException {
		try {
			javaSleep(10000);
			for(WebElement name:webElements(username)) {
				if(getText(name).equals("More")) {
					
				}
				else {
					doubleClickOnElement(name);
				}
			}
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void gotoMyProfilePage() throws MyException {
		try {
			clickOnUsername();
			waitUntillTheElementToBeClickable(webElement(myprofileoption));
			clickOnElement(webElement(myprofileoption));
			waitUntillTheElementToBeClickable(webElement(username1));
			clickOnElement(webElement(username1));
			Reporter.log("Went to profile page ");
			Loggers.info(HomePage.class.getName(), " Went to profile page ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void gotoMyAddressPage(String fname) throws MyException {
		try {
			gotoMyProfilePage();
			waitUntillTheElementToBeClickable(webElement(manageaddressoption));
			clickOnElement(webElement(manageaddressoption));
			Reporter.log("Went to address page ");
			Loggers.info(HomePage.class.getName(), " Went to address page ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void gotoCartPage() throws MyException {
		try {
			clickOnElement(webElement(carticon));
			Reporter.log("Went to cart page ");
			Loggers.info(HomePage.class.getName(), " Went to Cart Page ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void searchingForProduct(String search) throws MyException {
		try {
			javaSleep(5000);
			enterText(webElement(searchingplace),search);
			clickOnElement(webElement(searchicon));
			javaSleep(10000);
			Reporter.log("searching for "+search);
			Loggers.info(HomePage.class.getName(), " Searching for your product ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void clickOnProduct(String productname,String category) throws MyException {
		try {
			javaSleep(10000);
			String xPathproduct = null;
			utl.waitUtilThePageLoad();
			if(category.equals("dress"))
				xPathproduct="//a[@title="+'"'+productname+'"'+"]";
			if(category.equals("shoes"))
				xPathproduct="//a[@title='"+productname+"']";//xPathproduct="//div[@data-tkid='"+"6dc666eb-5a3e-4a49-91df-483eeba0d38b.SHOFZ9YT86XTZSXZ.SEARCH"+".]";
			if(category.equals("headphones"))
				xPathproduct="//a[@title='"+productname+"']";
			
			WebElement reqproduct=driver.findElement(By.xpath(xPathproduct));
			waitUtilTheElementVisible(reqproduct);
			clickOnElement(reqproduct);
			Reporter.log("Clicked on "+productname);
			Loggers.info(HomePage.class.getName(), " Your product is selected ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean isSearchWorking(String word) throws MyException {
		boolean flag=false;
		try {
			for(WebElement productname:webElements(productnamelist)) {
				flag=getText(productname).contains(word);
				if(flag==false)
					break;
			}
			Reporter.log("Checking for searching functionality "+flag);
			Loggers.info(HomePage.class.getName(), " Checking searching functionality ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void goToTravelPage() throws MyException {
		try {
			javaSleep(5000);
			clickOnElement(webElement(traveloption));
			Reporter.log("went to travel page");
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to go to travel page");
		}
	}
}