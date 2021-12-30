package com.ae.tests;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.context.Constants;
import com.ae.qa.pages.ContactUsPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.MsgSucessPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ContactUsFormTest extends BaseTest {

	@Test
	public void contactUs() {
		LogUtil.info("Conatact with owner test has begun (Test case 6).");
		try {
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");

			ContactUsPage contactUs = homePage.clickContactUs();
			LogUtil.info("Clicked on ContactUs sucessfully and Navigated");

			MsgSucessPage msgSucessPage = contactUs.fillGetInTouchDetails(Constants.imgPath);
			LogUtil.info("Contact form filled and submitted");
			softAssertion.assertTrue(msgSucessPage.isTxtSucessMsgVisible());
			LogUtil.info("Sucess text message is visible after submiting conatact form");

			Map<Object, Object> titleAndClick = msgSucessPage.clickHomeBtn();
			softAssertion.assertEquals(titleAndClick.get("title").toString(), "Automation Exercise");
			LogUtil.info("User navigated to home page sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtil.info("Conatact with owner test has ended (Test case 6).");
	}
}
