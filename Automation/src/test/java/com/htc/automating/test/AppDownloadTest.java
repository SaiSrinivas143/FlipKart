package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class AppDownloadTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void downloadingAppTest_ForValidUser(Map<String,String> user) throws MyException  {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			Assert.assertTrue(login.isMyProfileDisplayed());
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.goToDownloadPage();
			Assert.assertTrue(download.downloadApp());
			child=parent.createNode("Is gogle play store visible ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
