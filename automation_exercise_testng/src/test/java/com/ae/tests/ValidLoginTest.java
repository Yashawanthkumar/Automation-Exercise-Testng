package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.AccDeletedPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ValidLoginTest extends BaseTest {

	@Test
	public void validSignIn() {
		LogUtil.info("Validating login page with valid credentials test has begun (Test case 2).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtLoginToAccVisible());
			LogUtil.info("Login to your account is displayed");
			DashBoardPage dashBoardPage = signUpLoginPage.loginToAccount("yashawant@gmail.com", "123");
			softAssertion.assertTrue(dashBoardPage.isLogginUserNameVisible());
			LogUtil.info("Logged in as Username is displayed sucessfully");
			AccDeletedPage accDeletedPage = dashBoardPage.clickDeleteAcc();
			LogUtil.info("Account is deleted");
			softAssertion.assertTrue(accDeletedPage.accDeletedVisible());
			LogUtil.info("Account deleted is displayed sucessfully");
			LogUtil.info("User can Sign-In and delete account sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Validating login page with valid credentials test has ended (Test case 2).");
	}
}