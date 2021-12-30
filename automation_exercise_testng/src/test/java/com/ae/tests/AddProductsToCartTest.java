package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class AddProductsToCartTest extends BaseTest{

	@Test
	public void addProductTocart() {
		LogUtil.info("Adding product to cart test has begun (Test case 12).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(),"Automation Exercise - All Products");
			LogUtil.info("Driver Navigated to All products page sucessfully");
			softAssertion.assertTrue(productsDetailPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			CartPage cartPage=productsDetailPage.hoverAndAddToCart();
			LogUtil.info("Products are added to cart, after clicking continue to shopping button");
			softAssertion.assertEquals(cartPage.sizeOfProductCart(),2);
			LogUtil.info("Both products are displayed in the cart section");
			softAssertion.assertTrue(cartPage.verifyingDetailsDisplay());
			LogUtil.info("Price, Quantity, and Total price of the every product is displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Adding product to cart test has ended (Test case 12).");
	}
}