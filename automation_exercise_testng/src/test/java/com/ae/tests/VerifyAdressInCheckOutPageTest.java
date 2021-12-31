package com.ae.tests;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.AccDeletedPage;
import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.CheckOutPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class VerifyAdressInCheckOutPageTest extends BaseTest {

	@Test
	public void pOLoginBeforeCheckout() {
		LogUtil.info("Verifying whether the adress is matching with registered address test has begun (Test case 23).");
		try {
			HashMap<Object, Object> values;
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			LogUtil.info("Navigated to Homepage sucessfully");
			SignUpLoginPage signUpLoginPage = homePage.signUpOrLogin();
			LogUtil.info("Clicked on Sign up Or Login button sucessfully");
			softAssertion.assertTrue(signUpLoginPage.isTxtLoginToAccVisible());
			LogUtil.info("Login to your account is displayed");
			DashBoardPage dashBoardPage = signUpLoginPage.loginToAccount("yash5@gmail.com", "1234");
			softAssertion.assertTrue(dashBoardPage.isLogginUserNameVisible());
			LogUtil.info("Logged in as Username is displayed sucessfully");
			ProductsPage productsPage = dashBoardPage.clickOnProducts();
			softAssertion.assertTrue(productsPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			CartPage cartPage = productsPage.hoverAndAddToCart();
			LogUtil.info("Products are added to cart, and Cart page is dipalyed");
			values = cartPage.clickOnCheckout();
			CheckOutPage checkOutPage = (CheckOutPage) values.get("checkOutPage");
			LogUtil.info("Products in Cart are moved to checkout");
			softAssertion.assertTrue(checkOutPage.isAddressVisible());
			LogUtil.info("Billing address and delivery addresses verified");
			softAssertion.assertTrue(checkOutPage.allAdressInfoVerification());
			LogUtil.info("Billing address and delivery addresses verified and they are matching with adress given while registering account");
			AccDeletedPage accDeletedPage = checkOutPage.clickDeleteAcc();
			LogUtil.info("Account is deleted");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Verifying whether the adress is matching with registered address test has ended (Test case 23).");
	}
}