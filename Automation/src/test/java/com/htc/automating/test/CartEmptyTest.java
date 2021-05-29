package com.htc.automating.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class CartEmptyTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void removingProductsFromCartForValidUser(Map<String,String> user)  {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.gotoCartPage();
			cartpage.emptyTheCart();
			Assert.assertTrue(cartpage.isMyCartEmpty());
			child=parent.createNode(" Your cart is empty ");
			cartpage.navigateBack();
			Reporter.log("User "+user.get("Mobile")+" logged out");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
