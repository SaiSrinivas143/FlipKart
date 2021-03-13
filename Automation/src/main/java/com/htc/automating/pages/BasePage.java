package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.Utitlity;

public class BasePage extends Utitlity{
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,GlobalVariables.TIMEOUT_TIME);
		PageFactory.initElements(driver, this);
	}
	
	public void waitUntillTheElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUtilTheElementVisible(WebElement element){
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void javaSleep(int Seconds) {
		try {
			Thread.sleep(Seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}