package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ScrollWithUpButtonTest extends BaseTest {
	
	@Test
	public void scrollWithUpButtonTest() {
		LogUtil.info("Clicking up button arrow test has begun (Test case 25).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			softAssertion.assertTrue(homePage.isSubscriptionVisible());
			LogUtil.info("Subscription text is visible");
			homePage.clickOnButtonUp();
			LogUtil.info("Clicked on up arrow and page moved up sucessfully");
			softAssertion.assertTrue(homePage.isTxtAutomationEngineerVisible());
			LogUtil.info("Full-Fledged practice website for Automation Engineers is displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Clicking up button arrow test has ended (Test case 25).");
	}
}
