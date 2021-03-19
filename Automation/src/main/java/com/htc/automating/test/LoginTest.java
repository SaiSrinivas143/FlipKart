package com.htc.automating.test;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void validAndInvalidLoginTest_ShouldLoginForValidUser(Map<String,String> user) throws IOException {
		login.doLogIn(user.get("Email"), user.get("Password"));
		if(user.get("IsValid").equals("yes")) {
			Assert.assertTrue(login.isMyDashboardVisible());
			login.popupTheSuccessMsg();
			login.doLogOut();
		}
		
		if(user.get("IsValid").equals("no")) {
			Assert.assertTrue(login.isErrorMsgDisplayed());
		}	
	}
}
