package com.htc.automating.test;


import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.htc.automating.base.BaseTest;
import com.htc.automating.pages.LogInPage;
import com.htc.reports.TestListenerHtml;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "LoginCredentials",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void validAndInvalidLoginTest_ShouldLoginForValidUser(Map<String,String> mapdata) throws IOException {
		login.doLogIn(mapdata.get("Email"), mapdata.get("Password"));
		if(mapdata.get("IsValid").equals("yes")) {
			Assert.assertTrue(login.isMyDashboardVisible());
			login.popupTheSuccessMsg();
			login.doLogOut();
		}
		
		if(mapdata.get("IsValid").equals("no")) {
			Assert.assertTrue(login.isErrorMsgDisplayed());
		}	
	}
}
