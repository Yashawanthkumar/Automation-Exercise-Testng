package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.MenCategoryPage;
import com.ae.qa.pages.WomenCategoryPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ViewCategoryProductsTest extends BaseTest{
	
	@Test
	public void viewCategoryProducts() {
		LogUtil.info("View category products testcase has begun (Test case 18).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			softAssertion.assertTrue(homePage.isCategoryVisible());
			LogUtil.info("In Left-side Category list is displayed");
			homePage.clickOnWomenCategory();
			LogUtil.info("Clicked on women category sucessfully");
			WomenCategoryPage womenCategoryPage=homePage.clickOnWomenCategoryDress();
			LogUtil.info("Clicked on women category[Dress] sucessfully");
			softAssertion.assertTrue(womenCategoryPage.isTxtWomenCategoryProductsVisible());
			LogUtil.info("Text Women Dress Products is displayed");
			MenCategoryPage MenCategoryPage=womenCategoryPage.clickOnMenCategoryProducts();
			LogUtil.info("Clicked on men category and Tshirt category selected sucessfully");
			softAssertion.assertTrue(MenCategoryPage.isTxtMenCategoryProductsVisible());
			LogUtil.info("Men - Tshirts Products is displayed");
		}catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("View category products testcase has ended (Test case 18).");
	}
}