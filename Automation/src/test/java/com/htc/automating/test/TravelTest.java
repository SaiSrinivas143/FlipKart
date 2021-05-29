package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class TravelTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void flightsAvailabilityTest(Map<String,String> user) throws MyException  {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.goToTravelPage();
			tpage.searchFlight(user);
			Assert.assertTrue(tpage.isFlightAvailable());
			child=parent.createNode(" Flight availability on particular date ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
