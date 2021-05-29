package com.htc.automating.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.htc.automating.base.BasePage;
import com.htc.automating.pageobjects.ITravelPageObjects;
import com.htc.automating.util.javautility.MyException;

public class TravelPage extends BasePage implements ITravelPageObjects{

	public TravelPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isFlightAvailable() throws MyException {
		boolean flag = false;
		try {
			flag = isDisplayed(webElement(bookbutton));
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to find month and year");
		}
		return flag;
	}
	
	private void clickOnMonthAndYear(String month,String year) throws MyException {
		try {
			boolean flag=getText(webElements(leftrightmy).get(0)).equals(month+" "+year);
			while(flag==false) {
				clickOnElement(webElements(leftrightarrows).get(1));
				javaSleep(5000);
				flag=getText(webElements(leftrightmy).get(0)).equals(month+" "+year);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to find month and year");
		}
	}
	
	public void clickOnDate(String Tdate) throws MyException {
		try {
			for(WebElement element : webElements(date)) {
				if(getText(element).startsWith(Tdate)) {
					clickOnElement(element);
					javaSleep(5000);
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to find date");
		}
	}
	
	private void setDate(String date) throws MyException {
		try {
			String[] dates = date.split("-");
			String tdate = dates[0];
			String tmonth = dates[1];
			String tyear = dates[2];
			clickOnMonthAndYear(tmonth,tyear);
			clickOnDate(tdate);
		}catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to find required date");
		}
	}
	
	private void selectTravellersDetails() throws MyException {
		//String[] persons = travellers.split(",");
		try {
			clickOnElement(webElement(donebutton));
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to select travellers");
		}
	}
	
	public void searchFlight(Map<String,String> traveldetails) throws MyException {
		try {
			clickOnElement(webElement(fromtextbox));
			for(WebElement element : webElements(citynames)) {
				if(getText(element).contains(traveldetails.get("From")))
					clickOnElement(element);
			}
			clickOnElement(webElement(totextbox));
			for(WebElement element : webElements(citynames)) {
				if(getText(element).contains(traveldetails.get("To")))
					clickOnElement(element);
			}
			clickOnElement(webElement(departon));
			setDate(traveldetails.get("Date"));	
			//selectTravellersDetails();
			clickOnElement(webElement(searchbutton));
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("Unable to search");
		}
	}
}