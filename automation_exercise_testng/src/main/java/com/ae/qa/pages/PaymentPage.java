package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class PaymentPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//input[@name='name_on_card']")
	public WebElement editTxtNameOnCard;

	@FindBy(how = How.XPATH, using = "//input[@name='card_number']")
	public WebElement editTxtCardNum;

	@FindBy(how = How.XPATH, using = "//input[@name='cvc']")
	public WebElement editTxtCvv;

	@FindBy(how = How.XPATH, using = "//input[@name='expiry_month']")
	public WebElement editTxtExpMonth;

	@FindBy(how = How.XPATH, using = "//input[@name='expiry_year']")
	public WebElement editTxtExpYear;

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	public WebElement btnPayAndConfirm;

	@FindBy(how = How.XPATH, using = "//div[@id='success_message']")
	public WebElement txtMsgSucess;

	@SuppressWarnings("deprecation")
	public DashBoardPage fillCardDetails() {
		editTxtNameOnCard.sendKeys("Yashawantkumar H");
		editTxtCardNum.sendKeys("6057 3748 2846");
		editTxtCvv.sendKeys("899");
		editTxtExpMonth.sendKeys("09");
		editTxtExpYear.sendKeys("2030");
		btnPayAndConfirm.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return new DashBoardPage();
	}
}
