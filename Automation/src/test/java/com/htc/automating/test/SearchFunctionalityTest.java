package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class SearchFunctionalityTest extends BaseTest{
	
	@Test(invocationCount = 2 ,dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void searchTest_shouldDisplaySameProductsAccordingToSearch(Map<String,String> user) {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.searchingForProduct(user.get("Searchingword"));
			Assert.assertTrue(home.isSearchWorking(user.get("Checkword")));
			child=parent.createNode(" verified searching functionality ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
