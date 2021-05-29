package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class UseMyCurrentLocationFunctionalityTest extends BaseTest {
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void shouldLocatePincode_AfterClickOnLocationButton(Map<String,String> user) {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.gotoMyAddressPage(user.get("First_Name"));
			Assert.assertFalse(address.isUseMyCurrentLocationWorking(user.get("Zipcode")));
			child=parent.createNode(" Verified location button functionality ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
