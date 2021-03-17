package com.htc.automating.util;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.htc.automating.base.BaseTest;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.reports.ExtentTestReport;

public class Utitlity {
	
	JavascriptExecutor js;
	protected static WebDriver driver=BaseTest.driver;
	
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
