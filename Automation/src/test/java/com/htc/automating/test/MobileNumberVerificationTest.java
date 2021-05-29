package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class MobileNumberVerificationTest extends BaseTest {
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void verifyUserMobileNumber(Map<String,String> user) {
		try {	
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.gotoMyProfilePage();
			Assert.assertTrue(profile.verifyMobileNumber(user.get("Mobile")));
			child=parent.createNode(" Your mobile number is verified ").pass("details");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


}
