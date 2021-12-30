package com.ae.tests;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.AccCreatedPage;
import com.ae.qa.pages.AccDeletedPage;
import com.ae.qa.pages.CartPage;
import com.ae.qa.pages.CheckOutPage;
import com.ae.qa.pages.DashBoardPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.PaymentPage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.pages.SignUpLoginPage;
import com.ae.qa.pages.SignUpPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class PORegisterWCheckOutTest extends BaseTest {
	
	@Test
	public void pORegisterWhileCheckout() {
		LogUtil.info("Place order and register user while checking out test has begun (Test case 14).");
		try {
			HashMap<Object,Object> values;
			SoftAssert softAssertion = new SoftAssert();
			HomePage homePage = new HomePage();
			Assert.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(),"Automation Exercise - All Products");
			LogUtil.info("Driver Navigated to All products page sucessfully");
			softAssertion.assertTrue(productsDetailPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			CartPage cartPage=productsDetailPage.hoverAndAddToCart();
			softAssertion.assertEquals(cartPage.getTitle(),"Automation Exercise - Checkout");
			LogUtil.info("Products are added to cart");
			values=cartPage.clickOnCheckout();
			cartPage=(CartPage) values.get("cartPage");
			softAssertion.assertTrue(cartPage.isModalVisible());
			LogUtil.info("Clicked on check out to order products");
			LogUtil.info("Need to Sign-In and Register Modal displayed");
			SignUpLoginPage signUpLoginPage=cartPage.clickToRegister();
			LogUtil.info("Navigated to SignUp or Sign In page to register User");
			values=signUpLoginPage.signupNameAndEmail("Yash N", "yashawant255@gmail.com");
			SignUpPage signUpPage=(SignUpPage) values.get("signUpPage");
			AccCreatedPage accCreatedPage = signUpPage.fillDetails();
			LogUtil.info("SignUp details filled and sucessfully created account");
			softAssertion.assertTrue(accCreatedPage.verifyTxtAccCreated());
			LogUtil.info("Account Created is displayed");
			DashBoardPage dashBoardPage = accCreatedPage.clickContinue();
			softAssertion.assertTrue(dashBoardPage.isLogginUserNameVisible());
			LogUtil.info("Logged in as Username is displayed sucessfully");
			cartPage=dashBoardPage.clickOnCart();
			LogUtil.info("Clicked on cart button sucessfully");
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
		LogUtil.info("Place order and register user while checking out test has ended (Test case 14).");
	}
}