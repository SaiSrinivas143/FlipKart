package com.htc.automating.util.seleniumutility.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htc.automating.base.BaseTest;
import com.htc.automating.globalvariables.GlobalVariables;

public class Utitlity {
	
	JavascriptExecutor js;
	protected static WebDriver driver=BaseTest.driver;
	private static Utitlity utl;
	
	private Utitlity() {}
	
	public static Utitlity getInstance() {
		if(utl==null)
			utl=new Utitlity();
		return utl;
	}
	
	public void addBorder(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red'",element);
	}
	
	public boolean isSame(String word1,WebElement label) {
		return ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0],':after')."+"getPropertyValue('content');", label).toString().equalsIgnoreCase(word1);
	}
	
	public boolean isPageReady() {	
		js=(JavascriptExecutor)driver;
		return (Boolean)js.executeScript("return document.readyState").equals("complete");
	}
	
	public void scrollUntillElementIsVisible(WebElement element) {	
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void refreshingBrowser(String msg) {	
		js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public void createAlert(String msg) {	
		js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+ msg +"')");
	}
	
	public void hightlighting(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public void addColor(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: lightblue;');", element);
	}
	
	public void flash(WebElement element) {
		String color = element.getCssValue("backgroundColor");
		for (int i=0;i<20;i++) {
			changeColor("rgb(0,200,2)",element);
			changeColor(color,element);
		}
	}
	
	private void changeColor(String Color, WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+ Color + "'", element);
	}
	
	public void waitUtilThePageLoad(){
		WebDriverWait wait= new WebDriverWait(driver,GlobalVariables.TIMEOUT_TIME);
		wait.until(driver->((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
}