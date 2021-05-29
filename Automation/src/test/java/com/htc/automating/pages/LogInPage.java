package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.ILogInPageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class LogInPage extends BasePage implements ILogInPageObjects{
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	private void clickOnUsername() throws MyException{
		javaSleep(10000);
		for(WebElement name:webElements(username)) {
			if(getText(name).equals("More")) {
				
			}
			else {
				waitUntillTheElementToBeClickable(name);
				doubleClickOnElement(name);
			}
		}
	}
	
	public boolean isMyProfileDisplayed() throws MyException {
		boolean flag=false;
		try {
			clickOnUsername();
			waitUtilTheElementVisible(webElement(Myprofileoption));
			flag=isDisplayed(webElement(Myprofileoption));
			if(flag)
				Loggers.info(LogInPage.class.getName(), "Login is Success");
			else
				Loggers.info(LogInPage.class.getName(), "Login is failed");
			Reporter.log("Comfirming the login function "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void doLogIn(String number,String Password) throws MyException{
		try {
			enterText(webElement(mobiletext),number);
			enterText(webElement(passwordtext),Password);
			clickOnElement(webElement(loginbutton2));		
			Loggers.info(LogInPage.class.getName(), "Entered into login window,entered credential");
			Reporter.log("Login with the user "+number);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to login");
		}
	}
	
	public void doLogOut() throws MyException {
		try {
			closeAdditionalWindow();
			switchToWindow(0);
			javaSleep(3000);
			clickOnUsername();
			javaSleep(3000);
			clickOnElement(webElement(logoutoption));
			Loggers.info(LogInPage.class.getName(), "Logout is Success");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to logout");
		}
	}
}