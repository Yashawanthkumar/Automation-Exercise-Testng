package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class AddToCartFRecomendsTest extends BaseTest {
	
	@Test
	public void addProductTocart() {
		LogUtil.info("Adding product to cart from Recomended products test has begun (Test case 22).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			CartPage cartPage=homePage.clickOnRecomendProduct();
			LogUtil.info("Recomended product is added to cart sucessfully");
			softAssertion.assertTrue(cartPage.productVisible());
			LogUtil.info("Product is visble in the cart");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Adding product to cart from Recomended products test has ended (Test case 22).");
	}
}
