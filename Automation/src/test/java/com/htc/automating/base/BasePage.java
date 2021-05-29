package com.htc.automating.base;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.seleniumutility.utilities.Utitlity;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class BasePage {
	
	private WebDriverWait wait;
	protected WebDriver driver;//=BaseTest.driver;
	protected Utitlity utl =  Utitlity.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,GlobalVariables.TIMEOUT_TIME);
		PageFactory.initElements(driver, this);
	}
	
	public Actions action = new Actions(BaseTest.driver);
	
	public void waitUntillTheElementToBeClickable(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void waitUtilTheElementVisible(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void javaSleep(int Seconds) throws MyException {
		try {
			Thread.sleep(Seconds);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public String getTitle() throws MyException {
		try {
			return driver.getTitle();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void selectByIndex(WebElement element, int index) throws MyException {
		try {
			if(element==null)
				throw new MyException("Element not found");
			Select select = new Select(element);
			select.selectByIndex(index);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void selectByValue(WebElement element, String value) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			Select select = new Select(element);
			select.selectByValue(value);	
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public String getAttributeValue(WebElement element, String attribute) throws MyException{
		try {
			return element.getAttribute(attribute);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public WebElement webElement(By locator) throws MyException{
		try {
			return driver.findElement(locator);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public List<WebElement> webElements(By locator) throws MyException{
		try {
			return driver.findElements(locator);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void clickOnElement(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.flash(element);
			waitUntillTheElementToBeClickable(element);
			element.click();
			javaSleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void doubleClickOnElement(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.flash(element);
			action.doubleClick(element).perform();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void mouseHover(WebElement element) throws MyException {
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.flash(element);
			action.moveToElement(element).perform();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean isDisplayed(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.addColor(element);
			return element.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean isSelected(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.hightlighting(element);
			return element.isSelected();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean isEnabled(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.hightlighting(element);
			return element.isEnabled();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void clearText(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			element.clear();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void enterText(WebElement element, String text) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			utl.addBorder(element);
			element.sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public String getText(WebElement element) throws MyException{
		try {
			if(element==null)
				throw new MyException("Element not found");
			return element.getText();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void refreshPage() throws MyException{
		try {
			if(driver==null)
				throw new MyException("driver found is null");
			driver.navigate().refresh();
			Loggers.info(BasePage.class.getName(), " Browser refreshed ");
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void navigateBack() throws MyException{
		try {
			if(driver==null)
				throw new MyException("driver found is null");
			driver.navigate().back();
			Loggers.info(BasePage.class.getName(), " Navigated to "+driver.getTitle());
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void switchToWindow(int index) throws MyException{
		try {
			if(driver==null)
				throw new MyException("driver found is null");
			String windowid=null;
			Set<String> windowIds = driver.getWindowHandles();
			Iterator<String> itr = windowIds.iterator();
			for(int i=0;i<=index;i++) {
				windowid=itr.next();
			}
			driver.switchTo().window(windowid);
			Loggers.info(BasePage.class.getName(), " Switched to window at index of "+index);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException(e.getMessage());
		}
	}
	
	public void closeAdditionalWindow() {
		try {
			if(driver==null)
				throw new MyException("driver found is null");
			if(driver.getWindowHandles().size()>1) {
				switchToWindow(0);
				String windowid=driver.getWindowHandle();
				for(String handle : driver.getWindowHandles()) {
					if(!handle.equals(windowid)) {
						driver.switchTo().window(handle);
						driver.close();
					}
				}
				Loggers.info(BasePage.class.getName(), " closed all extra windows ");
			}
		}catch(Exception e) {
			e.printStackTrace();
			//throw new MyException(e.getMessage());
		}
	}
} 