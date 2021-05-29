package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class ProfileVerificationTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void verifyUserNameAndGender(Map<String,String> user) {
		try {	
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.gotoMyProfilePage();
			profile.editProfileInfo(user.get("Fisrt_Name"), user.get("Last_Name"), user.get("Gender"));
			child=parent.createNode(" Your profile is edited ");
			Assert.assertTrue(profile.verifyProfileInfo(user.get("Fisrt_Name"), user.get("Last_Name"), user.get("Gender")));
			Assert.assertTrue(profile.isMyFullNameCorrect(user.get("Fisrt_Name"), user.get("Last_Name")));
			child=parent.createNode(" And your profile is verified ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}