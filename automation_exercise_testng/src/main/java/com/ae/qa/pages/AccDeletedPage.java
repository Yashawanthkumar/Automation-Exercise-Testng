package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class AccDeletedPage extends BasePage{
	
	@FindBy(how=How.XPATH, using="//b[text()='Account Deleted!']")
	public WebElement txtAccDeleted;
	
	@FindBy(how=How.XPATH, using="//a[text()='Continue']")
	public WebElement btnContinue;
	
	public boolean accDeletedVisible()
	{
		return txtAccDeleted.isDisplayed();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
}
