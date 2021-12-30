package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class DetailOfProductPage extends BasePage{
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']")
	public WebElement productDetail;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//h2")
	public WebElement txtproductName;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//p[1]")
	public WebElement txtproductCategory;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//span//span")
	public WebElement txtproductPrice;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//p[2]")
	public WebElement txtproductAvailblity;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//p[3]")
	public WebElement txtproductBrand;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']//p[4]")
	public WebElement txtproductCondition;
	
	@FindBy(how=How.XPATH, using="//div[@class='product-information']/span/input[1]")
	public WebElement editTextquantity;
	
	@FindBy(how=How.XPATH, using="//span/button[@class='btn btn-default cart']")
	public WebElement btnAddToCart;
	
	@FindBy(how=How.XPATH, using="//p//a[@href='/view_cart']")
	public WebElement btnViewCart;
	
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public WebElement editTextMail;
	
	@FindBy(how=How.XPATH, using="//input[@id='name']")
	public WebElement editTxtName;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='review']")
	public WebElement editTxtComment;
	
	@FindBy(how=How.XPATH, using="//a[text()='Write Your Review']")
	public WebElement txtWriteReview;
	
	@FindBy(how=How.XPATH, using="//button[@id='button-review']")
	public WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using="//span[text()='Thank you for your review.']")
	public WebElement txtSucessMsg;
	
	public boolean isWriteReviewVisible()
	{
		driver=scrollDownPage(driver,500);
		return txtWriteReview.isDisplayed();
	}
	
	public void writeReview()
	{
		editTxtName.sendKeys("Yashawantkumar");
		editTextMail.sendKeys("yashu5@gmail.com");
		editTxtComment.sendKeys("Good and Nice product");
		btnSubmit.click();
	}
	
	public boolean verifySucessMessage()
	{
		return txtSucessMsg.isDisplayed();
	}
	
	public void clickOnQuantity()
	{
		int i=0;
		while(i<=2)
		{
			editTextquantity.click();
			editTextquantity.sendKeys(Keys.ARROW_UP);
			i++;
		}
	}
	
	@SuppressWarnings("deprecation")
	public CartPage addToCartAndViewCart()
	{
		btnAddToCart.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		btnViewCart.click();
		return new CartPage();
	}
	
	public String getQuantityValue()
	{
		return editTextquantity.getText().toString();
	}
	
	public boolean isProductVisible()
	{
		return productDetail.isDisplayed();
	}
	
	public boolean isProductNameVisible()
	{
		return txtproductName.isDisplayed();
	}
	
	public boolean isProductCategoryVisible()
	{
		return txtproductCategory.isDisplayed();
	}
	
	public boolean isProductPriceVisible()
	{
		return txtproductPrice.isDisplayed();
	}
	
	public boolean isProductAvailabelityVisible()
	{
		return txtproductAvailblity.isDisplayed();
	}
	
	public boolean isProductConditionVisible()
	{
		return txtproductCondition.isDisplayed();
	}
	
	public boolean isProductBrandVisible()
	{
		return txtproductBrand.isDisplayed();
	}
}