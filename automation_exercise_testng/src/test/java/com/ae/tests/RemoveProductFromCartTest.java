package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class RemoveProductFromCartTest extends BaseTest{
	
	@Test
	public void registerUser() {
		LogUtil.info("Remove products from cart testcase has begun (Test case 17).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(),"Automation Exercise - All Products");
			LogUtil.info("Driver Navigated to All products page sucessfully");
			softAssertion.assertTrue(productsDetailPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			CartPage cartPage=productsDetailPage.hoverAndAddToCart();
			LogUtil.info("Products are added to cart");
			softAssertion.assertTrue(cartPage.verifyingDetailsDisplay());
			LogUtil.info("Price, Quantity, and Total price of the every product is displayed");
			softAssertion.assertTrue(cartPage.clickOnDeleteProduct());
			LogUtil.info("Product is deleted from the cart and verification completed");
		}catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Remove products from cart testcase has ended (Test case 17).");
	}
}
