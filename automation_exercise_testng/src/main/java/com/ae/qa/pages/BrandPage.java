package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class BrandPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//div[@class='features_items']/h2")
	public WebElement txtBrandProducts;
	
	@FindBy(how=How.XPATH, using="//a[@href='/brand_products/Kookie Kids']")
	public WebElement btnKookieKidsBrand;
	
	@FindBy(how=How.XPATH, using="//div[@class='features_items']")
	public WebElement viewBrandProducts;
	
	public boolean isTxtBrandProductsVisible()
	{
		return txtBrandProducts.isDisplayed();
	}
	
	public BrandPage clickOnKookieKidsBrand()
	{
		btnKookieKidsBrand.click();
		return new BrandPage();
	}
	
	public boolean isBrandProductsVisible()
	{
		return viewBrandProducts.isDisplayed();
	}
}
