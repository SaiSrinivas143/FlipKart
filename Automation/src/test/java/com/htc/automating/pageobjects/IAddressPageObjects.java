package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IAddressPageObjects {
	
	By manageaddressoption = By.xpath("//div[@class=\"NS64GK\"][text()=\"Manage Addresses\"]");
	By addnewaddressbutton = By.cssSelector("._1QhEVk");
	By locationbutton = By.xpath("//button[@class=\"_2KpZ6l _3JSQZW _3dESVI\"]");
	By addresstext = By.cssSelector("._3eUt2C");
	By canceloption = By.cssSelector("._1QaKv3 a");
	By nametextbox = By.xpath("//input[@tabindex=\"1\"]");
	By mobilenotextbox = By.xpath("//input[@tabindex=\"2\"]");
	By pincodetextbox = By.xpath("//input[@tabindex=\"3\"]");
	By localitytextbox = By.xpath("//input[@tabindex=\"4\"]");
	By addresstextbox = By.xpath("//textarea[@tabindex=\"5\"]");
	By citytextbox = By.xpath("//input[@tabindex=\"6\"]");
	By selectstatebydropdown = By.xpath("//select[@name=\"state\"]");//value="Andhra Pradesh
	By checkbox = By.cssSelector("._1XFPmK");
	By saveanddeliverherebutton = By.xpath("//button[@tabindex=\"10\"]");
	By changeAddressoption = By.cssSelector("._32l7f0");
	By editoption = By.cssSelector("._1MM7ZD");

	
	
	
	
	
	
	
	                     

}
