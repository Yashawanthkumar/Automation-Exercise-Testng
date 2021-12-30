package com.ae.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class CartPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//input[@id='susbscribe_email']")
	public WebElement editTextSubscription;
	
	@FindBy(how=How.XPATH, using="//button[@id='subscribe']")
	public WebElement btnSubscription;
	
	@FindBy(how=How.XPATH, using="//div/h2[text()='Subscription']")
	public WebElement txtSubscription;
	
	@FindBy(how=How.XPATH, using="//div[@id='success-subscribe']")
	public WebElement txtSucessSubscription;
	
	@FindBy(how=How.XPATH, using="//table[@id='cart_info_table']/tbody/tr")
	public List<WebElement> tableSizeOfCart;
	
	@FindBy(how=How.XPATH, using="//tbody/tr/td[@class='cart_price']")
	public List<WebElement> pricesOfProducts;
	
	@FindBy(how=How.XPATH, using="//tbody/tr/td[@class='cart_quantity']")
	public List<WebElement> quantityOfProducts;
	
	@FindBy(how=How.XPATH, using="//a[text()='Proceed To Checkout']")
	public WebElement btnCheckOut;
	
	@FindBy(how=How.XPATH, using="//tbody/tr/td[@class='cart_total']")
	public List<WebElement> totalPricesOfProducts;
	
	@FindBy(how=How.XPATH, using="//table[@id='cart_info_table']/tbody/tr/td[4]/button")
	public WebElement valueOfQuantites;
	
	@FindBy(how=How.XPATH, using="//p//a[@href='/login']")
	public WebElement modalSignUpOrSignIn;
	
	@FindBy(how=How.XPATH, using="//div[@id='checkoutModal']")
	public WebElement modal;
	
	@FindBy(how=How.XPATH, using="//table[@id='cart_info_table']/tbody/tr[1]/td[6]/a")
	public WebElement btnDeleteFirstProduct;
	
	@FindBy(how=How.XPATH, using="//li//a[@href='/login']")
	public WebElement btnSignUpSiginIn;
	
	public boolean clickOnDeleteProduct()
	{
		int prev=sizeOfProductCart();
		btnDeleteFirstProduct.click();
		int post=sizeOfProductCart();
		if(prev>post)
			return true;
		else
			return false;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isModalVisible()
	{
		return modal.isDisplayed();
	}
	
	public SignUpLoginPage clickToRegister()
	{
		modalSignUpOrSignIn.click();
		return new SignUpLoginPage();
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<Object,Object> clickOnCheckout()
	{
		HashMap<Object,Object> results=new HashMap<>();
		btnCheckOut.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		results.put("cartPage", new CartPage());
		results.put("checkOutPage", new CheckOutPage());
		return results;
	}
	
	public String verifyValueOfQuantities()
	{
		return valueOfQuantites.getText().toString();
	}
	
	public int sizeOfProductCart()
	{
		List<WebElement> rows = tableSizeOfCart;
		return rows.size();
	}
	
	public SignUpLoginPage loginIntoAccount()
	{
		btnSignUpSiginIn.click();
		return new SignUpLoginPage();
	}
	public boolean productVisible()
	{
		if(sizeOfProductCart()>0)
			return true;
		else
			return false;
	}
	
	public boolean isSucessSubVisible()
	{
		return txtSucessSubscription.isDisplayed();
	}
	
	public boolean isTxtSubscriptionVisible()
	{
		return txtSubscription.isDisplayed();
	}
	
	public void sendMailForSubscription(String email)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", editTextSubscription);
		editTextSubscription.sendKeys(email);
		btnSubscription.click();
	}
	
	public boolean verifyingDetailsDisplay()
	{
		List<WebElement> price = pricesOfProducts;
		List<WebElement> quantity = quantityOfProducts;
		List<WebElement> totalPrice = totalPricesOfProducts;
		return price.size()!=0 && quantity.size()!=0 && totalPrice.size()!=0;
	}
}