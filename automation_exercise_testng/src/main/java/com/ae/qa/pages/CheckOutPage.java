package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class CheckOutPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_delivery']")
	public WebElement txtDeliveryAddrs;
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_invoice']")
	public WebElement txtBillingAddrs;
	
	@FindBy(how=How.XPATH, using="//textarea[@class='form-control']")
	public WebElement editTextDescription;
	
	@FindBy(how=How.XPATH, using="//div/a[text()='Place Order']")
	public WebElement btnPlaceOrder;
	
	public boolean isAddressVisible()
	{
		return txtDeliveryAddrs.isDisplayed() && txtBillingAddrs.isDisplayed();
	}
	
	public void commentArea(String description)
	{
		editTextDescription.sendKeys(description);
	}
	
	public PaymentPage clickOnPlaceOrder()
	{
		btnPlaceOrder.click();
		return new PaymentPage();
	}
}
