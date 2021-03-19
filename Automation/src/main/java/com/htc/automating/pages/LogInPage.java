package com.htc.automating.pages;
import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LogInPage extends BasePage{
	
	public LogInPage(WebDriver driver) {
		super(driver);
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
	
	public void doLogIn(String Email,String Password) throws IOException, ElementNotVisibleException, ElementClickInterceptedException{
		try {
			utl.waitUtilThePageLoad();
			waitUntillTheElementToBeClickable(account);
			utl.addColor(account);
			this.goToLoginPrompt();			
			Reporter.log("Entering into login page");
			javaSleep(5000);
			waitUntillTheElementToBeClickable(email);
			this.email.sendKeys(Email);
			waitUntillTheElementToBeClickable(password);
			this.password.sendKeys(Password);
			Reporter.log("Credentials are entered successfully");
		
			javaSleep(10000);
			waitUntillTheElementToBeClickable(loginbutton);
			this.loginbutton.click();
			Reporter.log("Clicked on login button successfully");
		}catch(ElementNotInteractableException e) {
			e.getMessage();
		}catch(ElementNotSelectableException e) {
			e.getMessage();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}catch(WebDriverException e) {
			e.printStackTrace();
		}  
	}
	
	public void popupTheSuccessMsg() throws ElementNotVisibleException {
		try {
			utl.waitUtilThePageLoad();
			utl.createAlert("Login is success");
			javaSleep(3000);
			driver.switchTo().alert().accept();
		}catch(ElementNotInteractableException e) {
			e.getMessage();
		}catch(ElementNotSelectableException e) {
			e.getMessage();
		}
		
	}
}