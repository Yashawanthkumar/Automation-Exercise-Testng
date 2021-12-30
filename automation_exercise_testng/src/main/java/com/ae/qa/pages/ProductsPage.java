package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class ProductsPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//div[@class='features_items']")
	public WebElement listOfProducts;
	
	@FindBy(how=How.XPATH, using="//a[@href='/product_details/1']")
	public WebElement detailsOfFirstproduct;
	
	@FindBy(how=How.XPATH, using="//input[@id='search_product']")
	public WebElement searcBarProduct;
	
	@FindBy(how=How.XPATH, using="//button[@id='submit_search']")
	public WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//img[@src='/get_product_picture/1']")
	public WebElement findFirstProduct;
	
	@FindBy(how=How.XPATH, using="//img[@src='/get_product_picture/2']")
	public WebElement findSecondProduct;
	
	@FindBy(how=How.XPATH, using="//a[@data-product-id='1']")
	public WebElement btnFirstProductToCart;
	
	@FindBy(how=How.XPATH, using="//p//a[@href='/view_cart']")
	public WebElement btnViewCart;
	
	@FindBy(how=How.XPATH, using="//div[@class='modal-footer']//button")
	public WebElement btnContinueShopping;
	
	@FindBy(how=How.XPATH, using="//div[@class='brands_products']")
	public WebElement viewCategoryBrand;
	
	@FindBy(how=How.XPATH, using="//a[@href='/brand_products/Polo']")
	public WebElement btnPoloBrand;
	
	public BrandPage clickOnPoloBrand()
	{
		btnPoloBrand.click();
		return new BrandPage();
	}
	
	public boolean isBrandCategoryVisible()
	{
		return viewCategoryBrand.isDisplayed();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isProductListVisible()
	{
		return listOfProducts.isDisplayed();
	}
	
	public SearchedProductsPage searchProduct(String productName)
	{
		searcBarProduct.sendKeys(productName);
		btnSearch.click();
		return new SearchedProductsPage();
	}
	
	public DetailOfProductPage clickOnFirstProduct()
	{
		detailsOfFirstproduct.click();
		return new DetailOfProductPage();
	}
	
	@FindBy(how=How.XPATH, using="//a[@data-product-id='2']")
	public WebElement btnSecProductToCart;
	
	@SuppressWarnings("deprecation")
	public CartPage hoverAndAddToCart() throws InterruptedException
	{
		driver=scrollDownPage(driver,350);
		driver=hoverTo(driver,findFirstProduct);
	    btnFirstProductToCart.click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    btnContinueShopping.click();
	    driver=hoverTo(driver,findSecondProduct);
	    btnSecProductToCart.click();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    btnViewCart.click();
	    return new CartPage();
	}
}