package com.ae.tests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ExistEmailRegistrationTest extends BaseTest {

	@Test
	public void existingEmailVeify() {
		LogUtil.info("SignUp with existing email test has begun (Test case 5).");
		try {
			HashMap<Object,Object> values;
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtNewUserSignupVisible());
			LogUtil.info("New User signup text is displayed");
			values= signUpLoginPage.signupNameAndEmail("Yashawantkumar","yash3@gmail.com");
			softAssertion.assertTrue(((SignUpLoginPage) values.get("samePage")).isTxtEmailExistsVisible());
			LogUtil.info("Email already registered text is displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("SignUp with existing email test has ended (Test case 5).");
	}
}