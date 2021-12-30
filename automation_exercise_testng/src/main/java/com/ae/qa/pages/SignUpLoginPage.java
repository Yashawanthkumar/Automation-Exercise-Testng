package com.ae.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class SignUpLoginPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//h2[text()='New User Signup!']")
	public WebElement txtNewUserSignup;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Login to your account']")
	public WebElement txtLoginToAcc;
	
	@FindBy(how=How.XPATH, using="//form[@action='/login']//input[@name='email']")
	public WebElement editTextSignInMail;
	
	@FindBy(how=How.XPATH, using="//button[text()='Login']")
	public WebElement btnSignIn;
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement editTextSignInPasswd;
	
	@FindBy(how=How.XPATH, using="//input[@name='name']")
	public WebElement editTextName;
	
	@FindBy(how=How.XPATH, using="//form[@action='/signup']//input[@name='email']")
	public WebElement editTextSignupMail;
	
	@FindBy(how=How.XPATH, using="//button[text()='Signup']")
	public WebElement btnSignup;
	
	@FindBy(how=How.XPATH, using="//p[text()='Email Address already exist!']")
	public WebElement txtEmailExists;
	
	public boolean isTxtEmailExistsVisible()
	{
		return txtEmailExists.isDisplayed();
	}
	
	public boolean isTxtNewUserSignupVisible()
	{
		return txtNewUserSignup.isDisplayed();
	}
	
	public boolean isTxtLoginToAccVisible()
	{
		return txtLoginToAcc.isDisplayed();
	}
	
	public HashMap<Object, Object> signupNameAndEmail(String userName, String emailAddress)
	{
		HashMap<Object,Object> result=new HashMap<>();
		editTextName.sendKeys(userName);
		editTextSignupMail.sendKeys(emailAddress);
		btnSignup.click();
		result.put("samePage", new SignUpLoginPage());
		result.put("signUpPage", new SignUpPage());
		return result;
	}
	
	public DashBoardPage loginToAccount(String email, String password)
	{
		editTextSignInMail.sendKeys(email);
		editTextSignInPasswd.sendKeys(password);
		btnSignIn.click();
		return new DashBoardPage();
	}
	
	public String getTitle()
	{
		return driver.getTitle().toString();
	}
}
