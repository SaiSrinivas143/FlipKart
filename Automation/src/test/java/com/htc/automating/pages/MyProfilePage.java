package com.htc.automating.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.IMyProfilePageObjects;
import com.htc.automating.util.javautility.Loggers;
import com.htc.automating.util.javautility.MyException;

public class MyProfilePage extends BasePage implements IMyProfilePageObjects{

	public MyProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMyFullNameCorrect(String fname,String lname) throws MyException {
		boolean flag=false;
		try {
			javaSleep(3000);
			String name=fname+" "+lname;
			flag=getText(webElement(fullnametext)).equals(name);
			Reporter.log("Checking for full name "+flag);
			Loggers.info(MyProfilePage.class.getName(), " Is my full name displayed "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public boolean verifyProfileInfo(String fname,String lname,String gender) throws MyException {
		boolean flag=false;
		try {
			if(getAttributeValue(webElement(firstnametextbox),"value").equals(fname))
				if(getAttributeValue(webElement(lastnametextbox),"value").equals(lname))
					if(gender.equals("male")) {
						flag=isEnabled(webElement(maleradiooption));
					}
					if(gender.equals("female")) {
						flag=isEnabled(webElement(femaleradiooption));
					}
			
			clickOnElement(webElement(profilecanceloption));
			Reporter.log("Checking for profile info "+flag);
			Loggers.info(MyProfilePage.class.getName(), " Is my profile info correct "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public boolean verifyMobileNumber(String number) throws MyException {
		int i=1;
		boolean flag=false;
		try {
			for(WebElement mnumber : webElements(editformailandnumber)) {
				i++;
				if(i==3) {
					clickOnElement(mnumber);
				}
			}
			String number1="91"+number;
			flag=number1.equals(getAttributeValue(webElement(mobilenumbertextbox),"value").replaceAll("[^0-9]", ""));
			Reporter.log("Checking for mobile number "+flag);
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
		return flag;
	}
	
	public void reSetPassword(String oldpassword,String newpassword) throws MyException {
		try {
			clickOnElement(webElement(changepasswordoption));
			javaSleep(3000);
			enterText(webElement(oldpasswordtextbox),oldpassword);
			enterText(webElement(newpasswordtextbox),newpassword);
			enterText(webElement(retypenewpasswordtextbox),newpassword);
			javaSleep(15000);//to enter otp
			clickOnElement(webElement(submitbutton));
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
	
	public void editProfileInfo(String fname,String lname,String gender) throws MyException {
		try {
			clickOnElement(webElement(profileeditoption));
			clearText(webElement(firstnametextbox));
			enterText(webElement(firstnametextbox),fname);
			clearText(webElement(lastnametextbox));
			enterText(webElement(lastnametextbox),lname);
			if(gender.equals("male"))
				clickOnElement(webElement(maleradiooption));
			if(gender.equals("female"))
				clickOnElement(webElement(femaleradiooption));
			clickOnElement(webElement(profilesubmitbutton));
			Loggers.info(MyProfilePage.class.getName(), " Your profile was edited successfully ");
			Reporter.log("Edited profile info ");
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	}
}