package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class ProductCostVerificationTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void verifyCostInProductDescriptionAndOrderSummary(Map<String,String> user) {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.searchingForProduct(user.get("Product"));
			home.clickOnProduct(user.get("Product"), user.get("Category"));
			child=parent.createNode(" Selected your product ");
			String cost=product.getProductCost(); 
			product.buyProductNow(user);
			Assert.assertEquals(cost,order.getProductCost());
			child=parent.createNode(" Verified your product price in product description and order summary page ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
