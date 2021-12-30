package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class HomePageSubscriptionTest extends BaseTest {
	
	@Test
	public void verifingSubscription() {
		LogUtil.info("Verifing Subscription test has begun (Test case 10).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			homePage.sendMailForSubscription("yash@32");
			LogUtil.info("Scrolled down to footer and mail has been sent for subscription sucessfully");
			softAssertion.assertTrue(homePage.isSucessSubVisible());
			LogUtil.info("Message of mail subscription is displayed sucessfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Verifing Subscription test has ended (Test case 10).");
	}
}
