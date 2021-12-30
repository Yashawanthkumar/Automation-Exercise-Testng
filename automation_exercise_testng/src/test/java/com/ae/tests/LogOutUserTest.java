package com.ae.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class LogOutUserTest extends BaseTest {

	@Test
	public void signInAndLogOut() {
		LogUtil.info("User signIn and signOut test has begun (Test case 4).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			Assert.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtLoginToAccVisible());
			LogUtil.info("Login to your account is displayed");
			try {
				DashBoardPage dashBoardPage = signUpLoginPage.loginToAccount("yashawant1@gmail.com", "1234");
				softAssertion.assertTrue(dashBoardPage.isLogginUserNameVisible());
				LogUtil.info("Logged in as Username is displayed sucessfully");
				signUpLoginPage = dashBoardPage.clickLogout();
				Assert.assertEquals(signUpLoginPage.getTitle(), "Automation Exercise - Signup / Login");
				LogUtil.info("Navigated to Login Page sucessfully");
			} catch (Exception e) {
				LogUtil.info("Please ensure that email and password are valid");
			}
			LogUtil.info("User can Sign-In and SignOut sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("User signIn and signOut test has ended (Test case 4).");
	}
}