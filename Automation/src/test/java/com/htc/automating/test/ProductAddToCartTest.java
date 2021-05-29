package com.htc.automating.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.automating.base.BaseTest;
import com.htc.automating.util.javautility.MyException;

public class ProductAddToCartTest extends BaseTest{
	
	@Test(dataProvider = "madison_form_data",dataProviderClass = com.htc.automating.base.BaseDataProvider.class)
	public void shouldAddProductToCart_ForValidUser(Map<String,String> user)  {
		try {
			login.doLogIn(user.get("Mobile"),user.get("Password"));
			child=parent.createNode(" Login is success with "+user.get("Mobile"));
			home.searchingForProduct(user.get("Product"));
			home.clickOnProduct(user.get("Product"), user.get("Category"));
			child=parent.createNode(" Your product selected ");
			product.addProductToCart(user);
			Assert.assertTrue(cartpage.isMyCartPageVisible());
			child=parent.createNode(" Added to cart ");
		}catch(MyException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
