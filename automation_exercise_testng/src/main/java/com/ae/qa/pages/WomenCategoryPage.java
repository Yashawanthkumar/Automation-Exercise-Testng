package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class WomenCategoryPage extends BasePage {

	@FindBy(how=How.XPATH, using="//h2[text()='Women - Dress Products']")
	public WebElement txtWomenCategoryProducts;
	
	@FindBy(how=How.XPATH, using="//a[@href='#Men']")
	public WebElement btnMenCategory;
	
	@FindBy(how=How.XPATH, using="//a[@href='/category_products/3']")
	public WebElement btnMenCategoryTshirts;
	
	public boolean isTxtWomenCategoryProductsVisible()
	{
		return txtWomenCategoryProducts.isDisplayed();
	}
	
	@SuppressWarnings("deprecation")
	public MenCategoryPage clickOnMenCategoryProducts()
	{
		btnMenCategory.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		btnMenCategoryTshirts.click();
		return new MenCategoryPage();
	}
}
