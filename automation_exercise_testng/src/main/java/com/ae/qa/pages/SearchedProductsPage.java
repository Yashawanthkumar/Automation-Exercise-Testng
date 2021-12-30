package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class SearchedProductsPage extends BasePage{
	
	@FindBy(how=How.XPATH, using="//h2[text()='Searched Products']")
	public WebElement txtSearchProducts;
	
	@FindBy(how=How.XPATH, using="//div[@class='features_items']")
	public WebElement specificProducts;
	
	@FindBy(how=How.XPATH, using="//div//a[text()='Add to cart']")
	public WebElement hoverOnProduct;
	
	@FindBy(how=How.XPATH, using="//p//a[@href='/view_cart']")
	public WebElement btnViewCart;
	
	public boolean isSearchProductVisible()
	{
		return txtSearchProducts.isDisplayed();
	}
	
	public boolean serachedProductsVisible()
	{
		return specificProducts.isDisplayed();
	}
	
	@SuppressWarnings("deprecation")
	public CartPage clickOnAddToCart()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver=hoverTo(driver,hoverOnProduct);
		hoverOnProduct.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		btnViewCart.click();
		return new CartPage();
	}
}