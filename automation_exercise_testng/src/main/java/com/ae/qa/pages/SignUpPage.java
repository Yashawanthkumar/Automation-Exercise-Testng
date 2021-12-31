package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.context.Constants;
import com.ae.qa.util.BasePage;
import com.ae.qa.util.LogUtil;

public class SignUpPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="/html/body/section/div/div/div/div/h2/b")
	public WebElement txtAcInformation;
	
	@FindBy(how=How.XPATH, using="//label[@for='id_gender1']")
	public WebElement radioBtnGender;
	
	@FindBy(how=How.XPATH, using="//input[@id='password']")
	public WebElement editTextPasswd;
	
	@FindBy(how=How.XPATH, using="//select[@id='days']")
	public WebElement dropDownDate;
	
	@FindBy(how=How.XPATH, using="//select[@id='months']")
	public WebElement dropDownMonths;
	
	@FindBy(how=How.XPATH, using="//select[@id='years']")
	public WebElement dropDownYear;
	
	@FindBy(how=How.XPATH, using="//select[@id='days']/option[10]")
	public WebElement selectDate;
	
	@FindBy(how=How.XPATH, using="//select[@id='months']/option[12]")
	public WebElement selectMonth;
	
	@FindBy(how=How.XPATH, using="//select[@id='years']/option[22]")
	public WebElement selectYear;
	
	@FindBy(how=How.XPATH, using="//label[text()='Sign up for our newsletter!']")
	public WebElement checkBoxNewsLetter;
	
	@FindBy(how=How.XPATH, using="//label[text()='Receive special offers from our partners!']")
	public WebElement checkBoxSpecialOffers;
	
	@FindBy(how=How.XPATH, using="//input[@id='first_name']")
	public WebElement editTxtFirstName;
	
	@FindBy(how=How.XPATH, using="//input[@id='last_name']")
	public WebElement editTxtLasttName;
	
	@FindBy(how=How.XPATH, using="//input[@id='company']")
	public WebElement editTxtCompany;
	
	@FindBy(how=How.XPATH, using="//input[@id='address1']")
	public WebElement editTxtAddrs1;
	
	@FindBy(how=How.XPATH, using="//input[@id='address2']")
	public WebElement editTxtAddrs2;
	
	@FindBy(how=How.XPATH, using="//select[@id='country']")
	public WebElement dropDownCountry;
	
	@FindBy(how=How.XPATH, using="//select[@id='country']/option[text()='India']")
	public WebElement selectCountry;
	
	@FindBy(how=How.XPATH, using="//input[@id='state']")
	public WebElement editTxtState;
	
	@FindBy(how=How.XPATH, using="//input[@id='city']")
	public WebElement editTxtCity;
	
	@FindBy(how=How.XPATH, using="//input[@id='zipcode']")
	public WebElement editTxtZipcode;
	
	@FindBy(how=How.XPATH, using="//input[@id='mobile_number']")
	public WebElement editTxtMobileNum;
	
	@FindBy(how=How.XPATH, using="//button[text()='Create Account']")
	public WebElement btnCreateAcc;
	
	public String txtAccountInformation()
	{
		return txtAcInformation.getText().toString();
	}
	
	public AccCreatedPage fillDetails()
	{
		radioBtnGender.click();
		LogUtil.info("Gender clicked");
		editTextPasswd.sendKeys("1234");
		LogUtil.info("password sent");
		dropDownDate.click();
		LogUtil.info("Date clicked");
		selectDate.click();
		LogUtil.info("Date selected");
		dropDownMonths.click();
		LogUtil.info("Months clicked");
		selectMonth.click();
		LogUtil.info("Months selected");
		dropDownYear.click();
		LogUtil.info("Years clicked");
		selectYear.click();
		LogUtil.info("Years selected");
		checkBoxNewsLetter.click();
		LogUtil.info("News letter check box selected");
		checkBoxSpecialOffers.click();
		LogUtil.info("Offer check box selected");
		editTxtFirstName.sendKeys("Yashawantkumar");
		LogUtil.info("First name sent");
		editTxtLasttName.sendKeys("Hodlur");
		LogUtil.info("Last name sent");
		editTxtCompany.sendKeys(Constants.companyName);
		LogUtil.info("Company name sent");
		editTxtAddrs1.sendKeys(Constants.address1);
		LogUtil.info("Addrs1 sent");
		editTxtAddrs1.sendKeys(Constants.address2);
		LogUtil.info("Addrs2 sent");
		dropDownCountry.click();
		LogUtil.info("Country Clicked");
		selectCountry.click();
		LogUtil.info("Country Selected");
		editTxtState.sendKeys(Constants.state);
		LogUtil.info("State sent");
		editTxtCity.sendKeys(Constants.city);
		LogUtil.info("District sent");
		editTxtZipcode.sendKeys(Constants.zipCode);
		LogUtil.info("Zipcode sent");
		editTxtMobileNum.sendKeys(Constants.mobileNum);
		LogUtil.info("Number sent");
		btnCreateAcc.click();
		LogUtil.info("Clicked create account");
		
		return new AccCreatedPage();
	}
}