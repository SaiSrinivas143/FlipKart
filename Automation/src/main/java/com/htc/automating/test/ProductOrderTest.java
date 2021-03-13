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
		public void ProductOrderTest_ShouldCheckoutForValidUser(Map<Object,Object> mapdata) throws IOException {
			login.doLogIn(mapdata.get("Email").toString(), mapdata.get("Password").toString());
			if(mapdata.get("IsValid").equals("yes")) {
				ProductOrderPage order= new ProductOrderPage(driver);
				order.orderingTheProduct();
				CheckoutPage checkout = new CheckoutPage(driver);
				checkout.doCheckOut();
				Assert.assertTrue(checkout.isSuccessmsgDisplayed());
				//login.popupTheSuccessMsg();
				login.doLogOut();
			}
			
			if(mapdata.get("IsValid").equals("no")) {
				//Assert.fail();
				Assert.assertTrue(login.isErrorMsgDisplayed());
			}	
		}
}
