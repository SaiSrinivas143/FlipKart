package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IProductDetailsPageObjects {
	
	By addtocartbutton = By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]");
	By colortext = By.cssSelector("#Color");
	By colors = By.xpath("//div[@class=\"_2C41yO _1pH70n _31hAvz\"]");
	By reverbredcoloroption = By.id("swatch-2-color");
	By Basebluecoloroption = By.id("swatch-0-color");
	By boldblackcoloroption = By.id("swatch-1-color");
	By buynowbutton =By.xpath("//button[@class=\"_2KpZ6l _2U9uOA ihZ75k _3AWRsL\"]");
	By sizes = By.xpath("//a[@class=\"_1fGeJ5 _2UVyXR _31hAvz\"]");
	By productprice = By.cssSelector("._25b18c div");//._25b18c div
}
////div[@class='_30jeq3 _16Jk6d']