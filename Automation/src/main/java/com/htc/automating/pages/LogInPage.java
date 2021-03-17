package com.htc.automating.pages;
import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
public class LogInPage extends BasePage{
	
	private Reporter reporter;
	
	public LogInPage() {
		super();
	}
	
	@FindBy(xpath="//span[text()=\"Account\"][1]")
	private WebElement account;
	
	@FindBy(xpath="//a[text()=\"Log In\"]")
	private WebElement loginicon;
	
	@FindBy(xpath="//input[@type=\"email\"][@name=\"login[username]\"]")
	private WebElement email;
	
	@FindBy(xpath="//input[@type=\"password\"][@name=\"login[password]\"]")
	private WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"][@name=\"send\"]")
	private WebElement loginbutton;
	
	@FindBy(xpath="//h1[text()=\"My Dashboard\"]")
	private WebElement mydashboard;
	
	@FindBy(xpath="//a[@title='Log Out']")
	private WebElement logoutbutton;
	
	@FindBy(css=".error-msg span")
	private WebElement errormsg;
	
	private void goToLoginPrompt() {
		account.click();
		loginicon.click();
	}
	public boolean isMyDashboardVisible() {
		return mydashboard.isDisplayed();
	}
	
	public void doLogOut() {
		account.click();
		javaSleep(1500);
		logoutbutton.click();	
	}
	
	public boolean isErrorMsgDisplayed() {
		return errormsg.isDisplayed();
	}
	
	public void doLogIn(String Email,String Password) throws IOException, ElementNotVisibleException{
		try {
			waitUtilThePageLoad();
			waitUntillTheElementToBeClickable(account);
			addColor(account);
			this.goToLoginPrompt();
			
			reporter.log("Entering into login page");
			javaSleep(5000);
			waitUntillTheElementToBeClickable(email);
			this.email.sendKeys(Email);
			waitUntillTheElementToBeClickable(password);
			this.password.sendKeys(Password);
			reporter.log("Credentials are entered successfully");
		
			javaSleep(10000);
			waitUntillTheElementToBeClickable(loginbutton);
			this.loginbutton.click();
			reporter.log("Clicked on login button successfully");
		}catch(ElementNotInteractableException e) {
			e.getMessage();
		}catch(ElementNotSelectableException e) {
			e.getMessage();
		}
	}
	
	public void popupTheSuccessMsg() throws ElementNotVisibleException {
		try {
			waitUtilThePageLoad();
			createAlert("Login is success");
			javaSleep(3000);
			driver.switchTo().alert().accept();
		}catch(ElementNotInteractableException e) {
			e.getMessage();
		}catch(ElementNotSelectableException e) {
			e.getMessage();
		}
		
	}
}