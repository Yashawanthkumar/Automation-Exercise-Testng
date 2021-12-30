package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.pages.SearchedProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class SearchProductTest extends BaseTest {

	@Test
	public void verifyProductsDetails() {
		LogUtil.info("Searching product test has begun (Test case 9).");
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
			SearchedProductsPage searchedProductsPage=productsDetailPage.searchProduct("Men Tshirt");
			LogUtil.info("Product name is entered and clicked on the search button");
			softAssertion.assertTrue(searchedProductsPage.isSearchProductVisible());
			LogUtil.info("Searched Product text is displayed sucessfully");
			softAssertion.assertTrue(searchedProductsPage.serachedProductsVisible());
			LogUtil.info("All the products with searched product name are visible");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Searching product test has ended (Test case 9).");
	}
}