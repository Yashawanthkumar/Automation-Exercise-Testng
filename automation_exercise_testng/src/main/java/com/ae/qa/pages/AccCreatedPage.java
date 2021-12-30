package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class AccCreatedPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//b[text()='Account Created!']")
	public WebElement txtAccCreated;
	
	@FindBy(how=How.XPATH, using="//a[text()='Continue']")
	public WebElement btnContinue;
	
	public boolean verifyTxtAccCreated()
	{
		return txtAccCreated.isDisplayed();
	}
	
	public DashBoardPage clickContinue()
	{
		btnContinue.click();
		return new DashBoardPage();
	}
}
