package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ScrollWithoutUpButtonTest extends BaseTest {
	
	@Test
	public void scrollWithOutUpButtonTest() {
		LogUtil.info("Without Clicking up button arrow page scroll up test has begun (Test case 26).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			softAssertion.assertTrue(homePage.isSubscriptionVisible());
			LogUtil.info("Subscription text is visible");
			homePage.scrollToUpWithoutButton();
			LogUtil.info("Without Click on up arrow button page moved up sucessfully");
			softAssertion.assertTrue(homePage.isTxtAutomationEngineerVisible());
			LogUtil.info("Full-Fledged practice website for Automation Engineers is displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Without Clicking up button arrow page scroll up test has ended (Test case 26).");
	}

}
