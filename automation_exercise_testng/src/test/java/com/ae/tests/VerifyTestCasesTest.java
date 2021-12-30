package com.ae.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.TestCasesPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class VerifyTestCasesTest extends BaseTest {

	@Test
	public void verifyTestCases() {
		LogUtil.info("Verifing Testcases page test has begun (Test case 7).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			Assert.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");

			TestCasesPage testCasesPage = homePage.clickOnTestCases();
			softAssertion.assertEquals(testCasesPage.getTitle(), "Automation Exercise - Test Cases");
			LogUtil.info("User navigated to testcases page sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Verifing Testcases page test has ended (Test case 7).");
	}
}