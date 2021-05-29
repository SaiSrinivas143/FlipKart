package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IHomePageObjects {
	
	By searchingplace = By.cssSelector("._3704LK");
	By searchicon = By.cssSelector(".L0Z3Pu svg");
	By carticon = By.cssSelector(".KK-o3G");
	By moreicon = By.xpath("//div[text()=\"More\"]");
	By myprofileoption = By.xpath("//div[@class=\"_3vhnxf\"][text()=\"My Profile\"]");
	By customercareoption = By.xpath("//div[@class=\"_3vhnxf\"][text()=\"Customer Care\"]");
	By downloadappoption = By.xpath("//div[@class=\"_3vhnxf\"][text()=\"Download App\"]");
	By username = By.xpath("//div[@class=\"exehdJ\"]");
	By username1 = By.xpath("//div[@class=\"exehdJ\"]");
	By productnamelist = By.cssSelector("._4rR01T");
	By manageaddressoption = By.xpath("//div[@class=\"NS64GK\"][text()=\"Manage Addresses\"]");
	By telephoneno = By.cssSelector("._1LJS6T a");
	//By traveloption = By.className("xtXmba");
	By traveloption = By.xpath("//p[text()='Flights']");

}
