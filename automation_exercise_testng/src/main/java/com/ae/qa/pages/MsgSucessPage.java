package com.ae.qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ae.qa.util.BasePage;

public class MsgSucessPage extends BasePage {
	
	@FindBy(how=How.XPATH, using="//div[@id='form-section']/a")
	public WebElement btnHome;
	
	@FindBy(how=How.XPATH, using="//div[@class='contact-form']//div[text()='Success! Your details have been submitted successfully.']")
	public WebElement txtSucessMsg;
	
	public boolean isTxtSucessMsgVisible()
	{
		return txtSucessMsg.isDisplayed();
	}
	
	public Map<Object, Object> clickHomeBtn()
	{
		btnHome.click();

		Map<Object, Object> result = new HashMap<>();
		result.put("page",new HomePage());
		result.put("title",driver.getTitle());
		
		return result;
	}
}
