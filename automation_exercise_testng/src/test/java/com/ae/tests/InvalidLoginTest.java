package com.ae.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class InvalidLoginTest extends BaseTest {

	@Test
	public void invalidSignIn() {
		LogUtil.info("User with invalid email test has begun (Test case 3).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			Assert.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");

			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtLoginToAccVisible());
			LogUtil.info("Login to your account is displayed");
			DashBoardPage dashBoardPage = signUpLoginPage.loginToAccount("yasha1@gmail.com", "123@321");
			softAssertion.assertTrue(dashBoardPage.isTxtIncorrectVisible());
			LogUtil.info("Incorrect credentials is displayed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("User with invalid email test has ended (Test case 3).");
	}
}