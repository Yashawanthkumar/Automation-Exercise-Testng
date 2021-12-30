package com.ae.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ae.qa.pages.DetailOfProductPage;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ProductsPage;
import com.ae.qa.util.BaseTest;
import com.ae.qa.util.LogUtil;

public class ProductsAndDetailsTest extends BaseTest {

	@Test
	public void verifyProductsDetails() {
		LogUtil.info("Verifing product and it's page details test has begun (Test case 8).");
		try
		{
			SoftAssert softAssertion= new SoftAssert();
			HomePage homePage = new HomePage();
			softAssertion.assertEquals(homePage.verifyHomepage(), "Automation Exercise");
			LogUtil.info("Navigated to Homepage sucessfully");
			ProductsPage productsDetailPage = homePage.clickOnProducts();
			softAssertion.assertEquals(productsDetailPage.getTitle(),"Automation Exercise - All Products");
			LogUtil.info("Driver Navigated to All products page sucessfully");
			softAssertion.assertTrue(productsDetailPage.isProductListVisible());
			LogUtil.info("List of the products is displayed");
			DetailOfProductPage detailOfProduct = productsDetailPage.clickOnFirstProduct();
			LogUtil.info("Clicked on the view product button of the first product");
			softAssertion.assertTrue(detailOfProduct.isProductVisible());
			LogUtil.info("Detail of first product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductNameVisible());
			LogUtil.info("Name of the product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductCategoryVisible());
			LogUtil.info("Category of the product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductPriceVisible());
			LogUtil.info("Price of the product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductAvailabelityVisible());
			LogUtil.info("Avialability of the product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductConditionVisible());
			LogUtil.info("Condition of the product is visible");
			softAssertion.assertTrue(detailOfProduct.isProductBrandVisible());
			LogUtil.info("Brand of the product is visible");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		LogUtil.info("Verifing product and it's page details test has ended (Test case 8).");
	}
}