package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface IRegistrationPageObjects {
	
	By createnewacountoption = By.cssSelector("._14Me7y");
	By mobilenumber = By.xpath("//input[@class=\"_2IX_2- VJZDxU\"]");
	By continuebutton = By.cssSelector("._1D1L_j span");
	By passwordplace = By.xpath("//input[@type=\"password\"]");
	By signupbutton = By.cssSelector("._1D1L_j span");

}
