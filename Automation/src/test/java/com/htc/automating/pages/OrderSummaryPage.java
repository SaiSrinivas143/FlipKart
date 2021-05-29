package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IOrderSummaryPageObjects;
import com.htc.automating.util.javautility.MyException;

public class OrderSummaryPage extends BasePage implements IOrderSummaryPageObjects{
	
	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getProductCost() throws MyException {
		String cost=null;
		try {
			javaSleep(15000);
			waitUtilTheElementVisible(webElement(pricetext));
			cost=getText(webElement(pricetext)).replaceAll("[^0-9]", "");
			clickOnElement(webElement(removeoption));
			switchToWindow(0);
			Reporter.log("cost of required product in order summary page is "+cost);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return cost;
	}
}