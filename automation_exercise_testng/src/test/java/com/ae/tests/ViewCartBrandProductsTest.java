package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.BrandPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ViewCartBrandProductsTest extends BaseTest {

	@Test
	public void viewCategoryProducts() {
		LogUtil.info("View brand category products testcase has begun (Test case 19).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsPage=homePage.clickOnProducts();
			LogUtil.info("Clicked on products button");
			softAssertion.assertTrue(productsPage.isBrandCategoryVisible());
			LogUtil.info("Brands are visible on left side bar");
			BrandPage brandPage=productsPage.clickOnPoloBrand();
			LogUtil.info("Clicked on Polo brand and navigated to Brand Page sucessfully");
			softAssertion.assertTrue(brandPage.isTxtBrandProductsVisible());
			LogUtil.info("Polo Brand products text is displayed");
			softAssertion.assertTrue(brandPage.isBrandProductsVisible());
			LogUtil.info("Polo Brand products are displayed");
			brandPage=brandPage.clickOnKookieKidsBrand();
			softAssertion.assertTrue(brandPage.isTxtBrandProductsVisible());
			LogUtil.info("Kookie Kid Brand products text is displayed");
			softAssertion.assertTrue(brandPage.isBrandProductsVisible());
			LogUtil.info("Kookie Kid Brand products are displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("View brand category products testcase has ended (Test case 19).");
	}
}