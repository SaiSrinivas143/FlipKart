package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IRegistrationPageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class RegistrationPage extends BasePage implements IRegistrationPageObjects{
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public void doRegister(String number,String password) throws MyException {
		try {
			clickOnElement(webElement(createnewacountoption));
			waitUtilTheElementVisible(webElement(mobilenumber));
			enterText(webElement(mobilenumber),number);
			clickOnElement(webElement(continuebutton));
			javaSleep(10000);
			enterText(webElement(passwordplace),password);
			Loggers.info(RegistrationPage.class.getName(), " You are successfully registered with us.. ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}