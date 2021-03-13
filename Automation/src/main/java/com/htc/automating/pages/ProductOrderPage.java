package com.htc.automating.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.htc.automating.util.Utitlity;

public class ProductOrderPage extends BasePage{
	
	public ProductOrderPage(WebDriver driver) {
		super(driver);
	}

	private Reporter reporter;
	
	@FindBy(css="#search")
	private WebElement searchingplace;
	
	@FindBy(xpath="//button[@title=\"Search\"]")
	private WebElement searchbutton;
	
	@FindBy(xpath="//img[@alt=\"Plaid Cotton Shirt\"][@id=\"product-collection-image-404\"]")
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
	
	private void setSearchItem() {
		searchingplace.sendKeys("jeans");
		searchbutton.click();
	}
	
	public void orderingTheProduct() {
		waitUtilThePageLoad();
		//WebDriverWait wait = new WebDriverWait(driver,40);
		waitUntillTheElementToBeClickable(searchbutton);
		reporter.log("Searching for a product");
		this.setSearchItem();
		javaSleep(5000);
		waitUntillTheElementToBeClickable(product);
		this.product.click();
		waitUntillTheElementToBeClickable(color);
		this.color.click();
		this.size1.click();
		try {
			this.noofproduct.clear();
			this.noofproduct.sendKeys("3");
		}
		finally {
			this.addtocartbutton.click();
		}
	}
}
