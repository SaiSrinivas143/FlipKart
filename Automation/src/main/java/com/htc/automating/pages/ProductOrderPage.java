package com.htc.automating.pages;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ProductOrderPage extends BasePage{
	
	public ProductOrderPage(WebDriver driver) {
		super(driver);
	}

	private Reporter reporter;
	
	@FindBy(css="#search")
	private WebElement searchingplace;
	
	@FindBy(xpath="//button[@title=\"Search\"]")
	private WebElement searchbutton;
	
	@FindBy(css="#product-collection-image-404")
	private WebElement product;
	
	@FindBy(xpath="//img[@alt=\"Royal Blue\"]")
	private WebElement color;
	
	@FindBy(xpath="//li[@class=\"option-s\"]")
	private WebElement size1;
	
	@FindBy(xpath="//li[@class=\"option-m\"]")
	private WebElement size2;
	
	@FindBy(xpath="//li[@class=\"option-l\"]")
	private WebElement size3;
	
	@FindBy(css="#qty")
	private WebElement noofproduct;
	
	@FindBy(xpath="//button[@onclick=\"productAddToCartForm.submit(this)\"]")
	private WebElement addtocartbutton;
	
	private void clickOnProduct(String productname) {
		driver.findElement(By.id(productname)).click();
	}
	
	private void clickOnColor(String col) {
		waitUntillTheElementToBeClickable(driver.findElement(By.xpath("//img[@alt=\'"+col+"\']")));
		driver.findElement(By.xpath("//img[@alt=\'"+col+"\']")).click();
	}
	private void clickOnSize(String size) {
		waitUntillTheElementToBeClickable(driver.findElement(By.name(size)));
		driver.findElement(By.name(size)).click();
	}
	
	private void setSearchItem(String search) {
		searchingplace.sendKeys(search);
		searchbutton.click();
	}
	
	public void orderingTheProduct(String pname,String Color,String Size,String quantity,String Search) throws ElementNotVisibleException{
		try {
			utl.waitUtilThePageLoad();
			waitUntillTheElementToBeClickable(searchbutton);
			reporter.log("Searching for a product");
			this.setSearchItem(Search);
			javaSleep(5000);
			this.clickOnProduct(pname);
			this.clickOnColor(Color);
			this.clickOnSize(Size);
			try {
				this.noofproduct.clear();
				this.noofproduct.sendKeys(quantity);
			}
			finally {
				this.addtocartbutton.click();
			}
			Reporter.log("product is added to cart");
		}catch(ElementNotInteractableException e) {
			System.out.println(e.getMessage());
		}catch(ElementNotSelectableException e) {
			System.out.println(e.getMessage());
		}catch(WebDriverException e) {
			e.printStackTrace();
		} 
	}
}
