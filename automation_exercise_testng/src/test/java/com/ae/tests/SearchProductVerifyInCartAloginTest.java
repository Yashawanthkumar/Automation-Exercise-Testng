package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.pages.SearchedProductsPage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class SearchProductVerifyInCartAloginTest extends BaseTest {
	
	@Test
	public void searchAndVefiryProductInCart() {
		LogUtil.info("Searching product and verify after login test has begun (Test case 20).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(), "Automation Exercise - All Products");
			LogUtil.info("Driver Navigated to All products page sucessfully");
			softAssertion.assertTrue(productsDetailPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			SearchedProductsPage searchedProductsPage=productsDetailPage.searchProduct("Winter Top");
			LogUtil.info("Product name is entered and clicked on the search button");
			softAssertion.assertTrue(searchedProductsPage.isSearchProductVisible());
			LogUtil.info("Searched Product text is displayed sucessfully");
			softAssertion.assertTrue(searchedProductsPage.serachedProductsVisible());
			LogUtil.info("All the products with searched product name are visible");
			CartPage cartPage=searchedProductsPage.clickOnAddToCart();
			softAssertion.assertTrue(cartPage.productVisible());
			LogUtil.info("All the products with product details are visible in the cart");
			SignUpLoginPage signUpLoginPage=cartPage.loginIntoAccount();
			DashBoardPage dashBoardPage=signUpLoginPage.loginToAccount("yash5@gmail.com", "1234");
			LogUtil.info("Logged in Sucessfully");
			cartPage=dashBoardPage.clickOnCart();
			LogUtil.info("Clicked on Cart button from dashboard");
			softAssertion.assertTrue(cartPage.productVisible());
			LogUtil.info("All the products with product details are visible in the cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Searching product and verify after login test has ended (Test case 20).");
	}
}
