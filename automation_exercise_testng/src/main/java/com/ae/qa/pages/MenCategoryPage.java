package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class MenCategoryPage extends BasePage{
	
	@FindBy(how=How.XPATH, using="//h2[text()='Men - Tshirts Products']")
	public WebElement txtMenCategoryProducts;
	
	public boolean isTxtMenCategoryProductsVisible()
	{
		return txtMenCategoryProducts.isDisplayed();
	}

}
