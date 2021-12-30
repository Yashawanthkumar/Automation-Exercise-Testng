package com.ae.tests;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.AccDeletedPage;
import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.CheckOutPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.PaymentPage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class POLoginBCheckOutTest extends BaseTest{

	@Test
	public void pOLoginBeforeCheckout() {
		LogUtil.info("Place order and register user before checking out test has begun (Test case 16).");
		try {
			HashMap<Object,Object> values;
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
			ProductsPage productsPage=dashBoardPage.clickOnProducts();
			softAssertion.assertTrue(productsPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			CartPage cartPage=productsPage.hoverAndAddToCart();
			LogUtil.info("Products are added to cart, and Cart page is dipalyed");
			values=cartPage.clickOnCheckout();
			CheckOutPage checkOutPage=(CheckOutPage) values.get("checkOutPage");
			LogUtil.info("Products in Cart are moved to checkout");
			softAssertion.assertTrue(checkOutPage.isAddressVisible());
			LogUtil.info("Billing address and delivery addresses verified");
			checkOutPage.commentArea("A good and nice product");
			LogUtil.info("Product is reviewed and comment is entered");
			PaymentPage paymentPage=checkOutPage.clickOnPlaceOrder();
			LogUtil.info("Navigated to Payment Page after clicking Place Order button");
			dashBoardPage=paymentPage.fillCardDetails();
			LogUtil.info("Order sucessfull message displayed after confirmation of payment");
			LogUtil.info("Navigated to DashBoard after sucessfully ordering product");
			AccDeletedPage accDeletedPage = dashBoardPage.clickDeleteAcc();
			LogUtil.info("Account is deleted");
			softAssertion.assertTrue(accDeletedPage.accDeletedVisible());
			LogUtil.info("Account deleted is displayed sucessfully");
			accDeletedPage.clickContinue();
			LogUtil.info("Clicked Continue button on Account deleted is displayed sucessfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Place order and register user before checking out test has ended (Test case 16).");
	}
}
