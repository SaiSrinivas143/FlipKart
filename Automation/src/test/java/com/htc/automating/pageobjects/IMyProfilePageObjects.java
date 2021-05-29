package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IMyProfilePageObjects {
	
	By profileeditoption = By.cssSelector(".oKZoMV");
	By changepasswordoption = By.xpath("//a[@class=\"_14Me7y\"]");
	By oldpasswordtextbox = By.xpath("//input[@name=\"oldPassword\"]");
	By newpasswordtextbox = By.xpath("//input[@name=\"newPassword\"]");
	By retypenewpasswordtextbox = By.xpath("//input[@name=\"retypePassword\"]");
	By submitbutton = By.xpath("//button[@type=\"submit\"][@class=\"_2KpZ6l _2UAxOt\"]");
	By firstnametextbox = By.xpath("//input[@name=\"firstName\"]");
	By lastnametextbox = By.xpath("//input[@name=\"lastName\"]");
	By maleradiooption = By.xpath("//label[@for=\"Male\"]//div");
	By femaleradiooption = By.xpath("//label[@for=\"Female\"]//div");
	By profilesubmitbutton = By.xpath("//button[@tabindex=\"5\"]");
	By editformailandnumber = By.xpath("//a[@class=\"_3memBI _14Me7y\"]");
	By mobilenumbertextbox = By.xpath("//input[@name=\"mobileNumber\"]");
	By mobilenumbersubmitbutton = By.xpath("//button[@class=\"_2KpZ6l _25vsmg _1-iOO7\"]");
	By profilecanceloption = By.cssSelector(".oKZoMV");
	By fullnametext = By.cssSelector("._1ruvv2");
}