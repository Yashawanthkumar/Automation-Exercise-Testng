package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//a[@href='/login']")
	public WebElement btnSignUpOrLogin;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[7]")
	public WebElement btnContactUs;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[2]")
	public WebElement btnProducts;
	
	@FindBy(how=How.XPATH, using="//button[text()='Test Cases']")
	public WebElement btnTestCases;
	
	@FindBy(how=How.XPATH, using="//input[@id='susbscribe_email']")
	public WebElement editTextSubscription;
	
	@FindBy(how=How.XPATH, using="//button[@id='subscribe']")
	public WebElement btnArrowSubscription;
	
	@FindBy(how=How.XPATH, using="//div[@id='success-subscribe']")
	public WebElement txtSucessSubscription;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[3]")
	public WebElement btnCart;
	
	@FindBy(how=How.XPATH, using="//a[@href='/product_details/1']")
	public WebElement btnViewFirstProduct;
	
	@FindBy(how=How.XPATH, using="//div[@class='left-sidebar']")
	public WebElement viewCategory;
	
	@FindBy(how=How.XPATH, using="//a[@href='#Women']")
	public WebElement womenCategory;
	
	@FindBy(how=How.XPATH, using="//a[@href='/category_products/1']")
	public WebElement womenCategoryDress;
	
	@FindBy(how=How.XPATH, using="//div[@class='recommended_items']")
	public WebElement viewRecomendProducts;
	
	@FindBy(how=How.XPATH, using="//div[@class='recommended_items']//a[@data-product-id='1']")
	public WebElement addRecomendProductToCart;
	
	@FindBy(how=How.XPATH, using="//p//a[@href='/view_cart']")
	public WebElement viewCart;
	
	public WomenCategoryPage clickOnWomenCategoryDress()
	{
		womenCategoryDress.click();
		return new WomenCategoryPage();
	}
	
	@SuppressWarnings("deprecation")
	public CartPage clickOnRecomendProduct()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",viewRecomendProducts);
		if(!addRecomendProductToCart.isDisplayed())
		{
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			clickOnRecomendProduct();
		}
		else
		{
			addRecomendProductToCart.click();
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			viewCart.click();
		}
		return new CartPage();
	}
	
	public boolean isCategoryVisible()
	{
		return viewCategory.isDisplayed();
	}
	
	@SuppressWarnings("deprecation")
	public void clickOnWomenCategory()
	{
		womenCategory.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public CartPage clickOnCart()
	{
		btnCart.click();
		return new CartPage();
	}
	
	public boolean isSucessSubVisible()
	{
		return txtSucessSubscription.isDisplayed();
	}
	
	public void sendMailForSubscription(String email)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", editTextSubscription);
		editTextSubscription.sendKeys(email);
		btnArrowSubscription.click();
	}
	public TestCasesPage clickOnTestCases()
	{
		btnTestCases.click();
		return new TestCasesPage();
	}
	
	public String verifyHomepage()
	{
		return driver.getTitle();
	}
	
	public SignUpLoginPage signUpOrLogin()
	{
		btnSignUpOrLogin.click();
		return new SignUpLoginPage();
	}
	
	public ContactUsPage clickContactUs()
	{
		btnContactUs.click();
		return new ContactUsPage();
	}
	
	public ProductsPage clickOnProducts()
	{
		btnProducts.click();
		return new ProductsPage();
	}
	
	public DetailOfProductPage clickOnViewFirstProductCart()
	{
		btnViewFirstProduct.click();
		return new DetailOfProductPage();
	}
}