package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.ICartPageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class CartPage extends BasePage implements ICartPageObjects{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMyCartEmpty() throws MyException {
		boolean flag=false;
		try {
			flag=isDisplayed(webElement(cartemptytext));
			Loggers.info(CartPage.class.getName(), " Are u removed all the products from cart "+flag);
			Reporter.log("Checking for cart empty "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	public boolean isMyCartPageVisible() throws MyException {
		boolean flag=false;
		try {
			utl.waitUtilThePageLoad();
			javaSleep(10000);
			waitUtilTheElementVisible(webElement(MyCartText));
			flag=isDisplayed(webElement(MyCartText));
			Loggers.info(CartPage.class.getName(), " Entered into cart Page "+flag);
			Reporter.log("Checking for cart page visibility "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void emptyTheCart() throws MyException {
		try {
			javaSleep(5000);
			int numberofproductsincart=Integer.parseInt(getText(webElement(MyCartText)).replaceAll("[^0-9]", ""));
			for(int i=1;i<=numberofproductsincart;i++) {
				waitUntillTheElementToBeClickable(webElement(removeoption));
				clickOnElement(webElement(removeoption));
				waitUntillTheElementToBeClickable(webElement(removebutton));
				clickOnElement(webElement(removebutton));
				javaSleep(10000);
				Loggers.info(CartPage.class.getName(), " Your Cart is empty now. ");
				Reporter.log("Able to remove all products in cart ");
			}	
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public boolean verifyTotalPrice() throws MyException {
		boolean flag=false;
		try {
			int tcost=0;
			int numberofproductsincart=Integer.parseInt(getText(webElement(MyCartText)).replaceAll("[^0-9]", ""));
			if(numberofproductsincart>1) {
				for(WebElement productcost:webElements(productcostlist)) {
					String cost=null;
					cost=getText(productcost);
					tcost+=Integer.parseInt(cost.replaceAll("[^0-9]", ""));
				}	
			}
			if(numberofproductsincart==1 && Integer.parseInt(getText(webElement(productcost)).replaceAll("[^0-9]", ""))>=500) {
				tcost=Integer.parseInt(getText(webElement(productcost)).replaceAll("[^0-9]", ""));
			}
			if(numberofproductsincart==1 && Integer.parseInt(getText(webElement(productcost)).replaceAll("[^0-9]", ""))<500) {
				tcost=Integer.parseInt(getText(webElement(shippingcost)).replaceAll("[^0-9]", ""))+Integer.parseInt(getText(webElement(productcost)).replaceAll("[^0-9]", ""));
			}
			if(Integer.parseInt(getText(webElement(totalamount)).replaceAll("[^0-9]", ""))==tcost)
				flag=true;
			Loggers.info(CartPage.class.getName(), " Is total price correct? "+flag);
			navigateBack();
			Reporter.log("Checking for cart value "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void placeTheOrder(String Qty) throws MyException {
		try {
			for(WebElement product:webElements(noofproductsinputbox)) {
				clearText(product);
				enterText(product,Qty);
			}
			clickOnElement(webElement(placeorderbutton));
			Loggers.info(CartPage.class.getName(), "Place the order button clicked");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}