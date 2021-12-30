package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class CartPageSubscriptionTest extends BaseTest {

	@Test
	public void verifyCartInSubscription() {
		LogUtil.info("Verifing subscription in cart page with email test has begun (Test case 11).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			CartPage cartPage = homePage.clickOnCart();
			LogUtil.info("Clicked on cart button of home page");
			softAssertion.assertTrue(cartPage.isTxtSubscriptionVisible());
			LogUtil.info("Subscription text is displayed");
			cartPage.sendMailForSubscription("yash32@gmail.com");
			softAssertion.assertTrue(cartPage.isSucessSubVisible());
			LogUtil.info("Mail for the subscription in cart page sent sucessfully");
			LogUtil.info("Sucessfull message displayed after subscription");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Verifing subscription in cart page with email test has ended (Test case 11).");
	}
}