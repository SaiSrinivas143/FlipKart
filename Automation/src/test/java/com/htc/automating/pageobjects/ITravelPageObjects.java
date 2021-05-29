package com.htc.automating.pageobjects;

import org.openqa.selenium.By;

public interface ITravelPageObjects {
	
	By fromtextbox = By.xpath("//input[@tabindex='01']");
	By totextbox =By.xpath("//input[@tabindex='02']");
	By departon = By.xpath("//input[@tabindex='03']");
	By leftrightmy = By.cssSelector("._1oqlzu");
	By leftrightarrows = By.cssSelector("._3CTB5G");
	By leftrightdatetable = By.cssSelector("aSgzfL");
	By date = By.className("jkj0H4");
	By travellersdetails = By.className("_19cAhQ _3ahBnm");//adults,children,infants
	By donebutton = By.className("aC49_F _14Me7y");
	By searchbutton = By.xpath("//button[@tabindex='5']");
	By returnon = By.xpath("//input[@tabindex='04']");
	By citynames = By.className("_3uA4ax");
	By bookbutton = By.className("u-ripple");
	
}
