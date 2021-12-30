package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.DetailOfProductPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ReviewProductTest extends BaseTest {
	
	@Test
	public void reviewProducts() {
		LogUtil.info("Adding review to the product test has begun (Test case 21).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(), "Automation Exercise - All Products");
			LogUtil.info("Clicked on products button and Navigated to Products page");
			DetailOfProductPage detailOfProductPage=productsDetailPage.clickOnFirstProduct();
			softAssertion.assertTrue(detailOfProductPage.isWriteReviewVisible());
			LogUtil.info("Write your Review text heading is visible");
			detailOfProductPage.writeReview();
			LogUtil.info("Review submitted for the product");
			softAssertion.assertTrue(detailOfProductPage.verifySucessMessage());
			LogUtil.info("Sucess message displayed after submitting the review for the product");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Adding review to the product test has begun (Test case 21).");
	}
}
