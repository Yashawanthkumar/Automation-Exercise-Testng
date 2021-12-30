package com.ae.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class ContactUsPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//h2[text()='Get In Touch']")
	public WebElement txtGetInTouch;
	
	@FindBy(how=How.XPATH, using="//input[@name='name']")
	public WebElement editTextUserName;
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	public WebElement editTextUserEmail;
	
	@FindBy(how=How.XPATH, using="//input[@name='subject']")
	public WebElement editTextSubject;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='message']")
	public WebElement editTextMsg;
	
	@FindBy(how=How.XPATH, using="//input[@type='file']")
	public WebElement btnChooseFile;
	
	@FindBy(how=How.XPATH, using="//input[@name='submit']")
	public WebElement btnSubmit;
	
	public boolean istxtGetInTouchVisible()
	{
		return txtGetInTouch.isDisplayed();
	}
	
	public MsgSucessPage fillGetInTouchDetails(String imgPath)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		editTextUserName.sendKeys("Yashawantkumar Hodlur");
		editTextUserEmail.sendKeys("yashawant1@gmail.com");
		js.executeScript("window.scrollBy(0,200)");
		editTextSubject.sendKeys("Need to update mobie number");
		js.executeScript("window.scrollBy(0,200)");
		editTextMsg.sendKeys("Please, help me to update mobile number");
		btnChooseFile.sendKeys(imgPath);
		js.executeScript("window.scrollBy(0,100)");
		btnSubmit.click();
		driver.switchTo().alert().accept();
		return new MsgSucessPage();
	}
}