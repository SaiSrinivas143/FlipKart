package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void validLoginTest_ShouldLoginForValidUser(Map<String,String> user) throws MyException  {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			Assert.assertTrue(login.isMyProfileDisplayed());
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
