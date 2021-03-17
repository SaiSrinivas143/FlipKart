package com.htc.automating.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.htc.automating.base.BaseTest;
import com.htc.automating.pages.CheckoutPage;
import com.htc.automating.pages.LogInPage;
import com.htc.automating.pages.ProductOrderPage;
import com.htc.reports.TestListenerHtml;

public class ProductOrderTest extends BaseTest{
		
		@Test(dataProvider = "LoginCredentials",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
		public void ProductOrderTest_ShouldCheckoutForValidUser(Map<String,String> mapdata) throws IOException {
			login.doLogIn(mapdata.get("Email"), mapdata.get("Password"));
			if(mapdata.get("IsValid").equals("yes")) {
				order.orderingTheProduct(mapdata.get("Product"),mapdata.get("color"),mapdata.get("Size"),mapdata.get("Quantity"),mapdata.get("Search"));
				checkout.doCheckOut(mapdata.get("Country"),mapdata.get("Zipcode"),mapdata.get("City"),mapdata.get("Street"),mapdata.get("Mobile"));
				Assert.assertTrue(checkout.isSuccessmsgDisplayed());
				login.doLogOut();
			}
			
			if(mapdata.get("IsValid").equals("no")) {
				Assert.assertTrue(login.isErrorMsgDisplayed());
			}	
		}
}
