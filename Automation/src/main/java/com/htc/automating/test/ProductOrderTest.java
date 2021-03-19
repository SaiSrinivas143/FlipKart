package com.htc.automating.test;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;


public class ProductOrderTest extends BaseTest{
		
		@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
		public void ProductOrderTest_ShouldCheckoutForValidUser(Map<String,String> user) throws IOException {
			login.doLogIn(user.get("Email"), user.get("Password"));
			if(user.get("IsValid").equals("yes")) {
				order.orderingTheProduct(user.get("Product"),user.get("color"),user.get("Size"),user.get("Quantity"),user.get("Search"));
				checkout.doCheckOut(user.get("Country"),user.get("Zipcode"),user.get("City"),user.get("Street"),user.get("Mobile"));
				Assert.assertTrue(checkout.isSuccessmsgDisplayed());
				login.doLogOut();
			}
			
			if(user.get("IsValid").equals("no")) {
				Assert.assertTrue(login.isErrorMsgDisplayed());
			}	
		}
}
