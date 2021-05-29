package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface ICartPageObjects {
	
	By noofproducts = By.cssSelector("._253qQJ");
	By removebutton = By.xpath("//div[@class=\"_3dsJAO _24d-qY FhkMJZ\"]");
	By removeoption =By.xpath("//div[@class=\"_1AtVbE col-12-12\"]//div[text()=\"Remove\"]");
	By placeorderbutton = By.xpath("//button[@class=\"_2KpZ6l _2ObVJD _3AWRsL\"]");
	By totalamount = By.xpath("//div[@class=\"Ob17DV _3X7Jj1\"]//span");
	By MyCartText = By.cssSelector("._3g_HeN");
	By cartemptytext = By.cssSelector("._1LCJ1U");
	By productcost = By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]");
	By productcostlist = By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]");
	By shippingcost = By.cssSelector("._3CWtsA");
	By noofproductsinputbox = By.cssSelector("._253qQJ");

}
