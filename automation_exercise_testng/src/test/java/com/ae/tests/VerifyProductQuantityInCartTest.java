package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.DetailOfProductPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class VerifyProductQuantityInCartTest extends BaseTest{
	
	@Test
	public void productQuantityIncart() {
		LogUtil.info("Verifying product quantities in cart test has begun (Test case 13).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			DetailOfProductPage detailOfProductPage=homePage.clickOnViewFirstProductCart();
			LogUtil.info("Clicked on the view product button of the first product");
			softAssertion.assertTrue(detailOfProductPage.isProductVisible());
			LogUtil.info("Details of the first product are visible");
			detailOfProductPage.clickOnQuantity();
			softAssertion.assertEquals("4",detailOfProductPage.getQuantityValue());
			LogUtil.info("The quantity value for the product is increased to 4");
			CartPage cartPage=detailOfProductPage.addToCartAndViewCart();
			softAssertion.assertEquals(cartPage.verifyValueOfQuantities(),"4");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Verifying product quantities in cart test has ended (Test case 13).");		
	}
}