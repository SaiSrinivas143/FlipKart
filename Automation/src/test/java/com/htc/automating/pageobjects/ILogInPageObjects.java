package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface ILogInPageObjects {
	
	By loginbutton1 =  By.cssSelector("._1_3w1N");
	By mobiletext   =  By.xpath("//input[@class=\"_2IX_2- VJZDxU\"]");
	By passwordtext =  By.xpath("//input[@class=\"_2IX_2- _3mctLh VJZDxU\"]");
	By loginbutton2  =  By.xpath("//button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]");
	By logoutoption  =  By.xpath("//div[@class=\"_3vhnxf\"][text()=\"Logout\"]");
	By username = By.xpath("//div[@class=\"exehdJ\"]");
	By Myprofileoption = By.xpath("//div[@class=\"_3vhnxf\"][text()=\"My Profile\"]");
	By errormsg = By.cssSelector("._2YULOR span");
		
}
