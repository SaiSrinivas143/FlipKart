package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htc.automating.base.BaseTest;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.Utitlity;

public class BasePage {
	
	private WebDriverWait wait;
	protected WebDriver driver;//=BaseTest.driver;
	protected Utitlity utl = new Utitlity();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
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
