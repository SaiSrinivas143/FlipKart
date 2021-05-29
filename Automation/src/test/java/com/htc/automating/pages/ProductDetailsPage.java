package com.htc.automating.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IProductDetailsPageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class ProductDetailsPage extends BasePage implements IProductDetailsPageObjects{
	

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getProductCost() throws MyException {
		String cost=null;
		try {
			javaSleep(15000);
			waitUtilTheElementVisible(webElement(productprice));
			cost=getText(webElement(productprice)).replaceAll("[^0-9]", "");
			Reporter.log("cost of required product in product description page is  "+cost);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return cost;
	}
	
	private void clickOnColor(String col) throws MyException {
		try {
			if(col.equals("Reverb Red"))
				clickOnElement(webElement(reverbredcoloroption));
			if(col.equals("Base Blue"))
				clickOnElement(webElement(Basebluecoloroption));
			if(col.equals("Bold Black"))
				clickOnElement(webElement(boldblackcoloroption));
			Reporter.log("Selected required color of product is "+col);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	private void clickOnSize(String size) throws MyException {
		try {
			for(WebElement productsize : webElements(sizes)) {
				System.out.println(productsize+"---"+size);
				if(getText(productsize).equals(size)) {
					utl.scrollUntillElementIsVisible(productsize);
					waitUntillTheElementToBeClickable(productsize);
					clickOnElement(productsize);
					Loggers.info(ProductDetailsPage.class.getName(), " Your required size was selected ");
	
				}
			} 
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void addProductToCart(Map<String,String> product) throws MyException {
		try {
			javaSleep(10000);
			switchToWindow(1);
			javaSleep(10000);
			if(product.get("Category").equals("shoes")) {
				clickOnSize(product.get("Length"));
				clickOnColor(product.get("Color"));
			}
			if(product.get("Category").equals("headphones")) {
				clickOnColor(product.get("color"));
			}
			clickOnElement(webElement(addtocartbutton));
			Loggers.info(ProductDetailsPage.class.getName(), " Your product is added to cart successfully ");
			Reporter.log("Product is added to cart ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void buyProductNow(Map<String,String> product) throws MyException {
		try {
			javaSleep(10000);
			switchToWindow(1);
			javaSleep(10000);
			if(product.get("Category").equals("shoes")) {
				clickOnSize(product.get("Length"));
				clickOnColor(product.get("color"));
			}
			if(product.get("Category").equals("headphones")) {
				clickOnColor(product.get("color"));
			}
			clickOnElement(webElement(buynowbutton));
			Loggers.info(ProductDetailsPage.class.getName(), " clicked on buynow button ");
			Reporter.log("Clicked on buy now option entered into order summary page ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}