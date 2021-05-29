package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IAddressPageObjects;
import com.htc.automating.util.javautility.MyException;

public class AddressPage extends BasePage implements IAddressPageObjects{

	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isUseMyCurrentLocationWorking(String pincode) throws MyException {
		boolean flag=false;
		try {
			javaSleep(10000);
			waitUtilTheElementVisible(webElement(addnewaddressbutton));
			clickOnElement(webElement(addnewaddressbutton));
			clickOnElement(webElement(locationbutton));
			waitUtilTheElementVisible(webElement(addresstext));
			flag=getText(webElement(addresstext)).replaceAll("[^0-9]", "").equals(pincode);
			clickOnElement(webElement(canceloption));
			Reporter.log("Checking for current location button working "+flag);
		} catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
}