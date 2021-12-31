package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.context.Constants;
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
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_delivery']//li[3]")
	public WebElement txtCompany;
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_delivery']//li[4]")
	public WebElement txtAddrs1;
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_delivery']//li[6]")
	public WebElement txtAddrs2;
	
	@FindBy(how=How.XPATH, using="//ul[@id='address_delivery']//li[8]")
	public WebElement txtMobileNum;
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav navbar-nav']/li[5]")
	public WebElement btnDeleteAcc;
	
	public AccDeletedPage clickDeleteAcc()
	{
		btnDeleteAcc.click();
		return new AccDeletedPage();
	}
	
	public boolean isAddressVisible()
	{
		return txtDeliveryAddrs.isDisplayed() && txtBillingAddrs.isDisplayed();
	}
	
	public boolean allAdressInfoVerification()
	{
		boolean flag1,flag2;
		flag1=txtCompany.getText().toString().equalsIgnoreCase(Constants.companyName)&&txtAddrs1.getText().toString().equalsIgnoreCase(Constants.address1+Constants.address2);
		flag2=flag1&&txtAddrs2.getText().toString().equalsIgnoreCase(Constants.city+" "+Constants.state+" "+Constants.zipCode);
		return flag2&&txtMobileNum.getText().toString().equalsIgnoreCase(Constants.mobileNum);
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