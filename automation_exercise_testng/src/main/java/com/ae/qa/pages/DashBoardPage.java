package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class DashBoardPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[9]")
	public WebElement txtLoginAs;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[5]")
	public WebElement btnDeleteAcc;
	
	@FindBy(how=How.XPATH, using="//p[text()='Your email or password is incorrect!']")
	public WebElement txtIncorrect;
	
	@FindBy(how=How.XPATH, using="//a[@href='/logout']")
	public WebElement btnLogout;
	
	@FindBy(how=How.XPATH, using="//li//a[@href='/view_cart']")
	public WebElement btnCart;
	
	@FindBy(how=How.XPATH, using="//li//a[@href='/products']")
	public WebElement btnProducts;
	
	@FindBy(how=How.XPATH, using="//a[text()='Download Invoice']")
	public WebElement btnDownloadInvoice;
	
	public void clickOnDownloadInvoice()
	{
		btnDownloadInvoice.click();
	}
	
	public ProductsPage clickOnProducts()
	{
		btnProducts.click();
		return new ProductsPage();
	}
	
	public CartPage clickOnCart()
	{
		btnCart.click();
		return new CartPage();
	}
	public SignUpLoginPage clickLogout()
	{
		btnLogout.click();
		return new SignUpLoginPage();
	}
	
	public boolean isLogginUserNameVisible()
	{
		return txtLoginAs.isDisplayed();
	}
	
	public AccDeletedPage clickDeleteAcc()
	{
		btnDeleteAcc.click();
		return new AccDeletedPage();
	}
	
	public boolean isTxtIncorrectVisible()
	{
		return txtIncorrect.isDisplayed(); 
	}
}