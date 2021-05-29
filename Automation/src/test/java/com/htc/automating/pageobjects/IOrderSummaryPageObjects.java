package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IOrderSummaryPageObjects {
	
	By pricetext = By.xpath("//span[@class=\"_2-ut7f _1WpvJ7\"]");
	By noofproducts = By.cssSelector("._253qQJ");
	By emailtextbox = By.cssSelector("._2ksRRJ");
	By continuebutton = By.xpath("//button[@class=\"_2KpZ6l _1seccl _3AWRsL\"]");
	By removeoption = By.cssSelector("._3dsJAO");
	By productremovetext = By.cssSelector(".LYTQKl");//Your checkout has no items.
}
