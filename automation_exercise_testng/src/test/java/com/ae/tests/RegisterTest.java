package com.ae.tests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.AccCreatedPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.pages.SignUpPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class RegisterTest extends BaseTest {

	@Test
	public void registerUser() {
		LogUtil.info("Register user testcase has begun (Test case 1).");
		try {
			HashMap<Object, Object> values;
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			
			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtNewUserSignupVisible());
			LogUtil.info("New User signup text is displayed");
			values = signUpLoginPage.signupNameAndEmail("Yashawantkumar", "yash5@gmail.com");

			SignUpPage signUpPage = (SignUpPage) values.get("signUpPage");
			LogUtil.info("Sign up process navigated further");
			softAssertion.assertEquals(signUpPage.txtAccountInformation(), "ENTER ACCOUNT INFORMATION");
			LogUtil.info("Enter Account Information is visible in the Page");
			AccCreatedPage accCreatedPage = signUpPage.fillDetails();
			LogUtil.info("SignUp details filled and sucessfully created account");
			softAssertion.assertTrue(accCreatedPage.verifyTxtAccCreated());
			LogUtil.info("Account Created is displayed");
			DashBoardPage dashBoardPage = accCreatedPage.clickContinue();
			softAssertion.assertTrue(dashBoardPage.isLogginUserNameVisible());
			LogUtil.info("Logged in as Username is displayed sucessfully");
//			AccDeletedPage accDeletedPage = dashBoardPage.clickDeleteAcc();
//			LogUtil.info("Account is deleted");
//			softAssertion.assertTrue(accDeletedPage.accDeletedVisible());
//			LogUtil.info("Account deleted is displayed sucessfully");
//			accDeletedPage.clickContinue();
//			LogUtil.info("Clicked Continue button on Account deleted is displayed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Register user testcase has ended (Test case 1).");
	}
}