package com.ae.qa.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.ae.qa.context.WebDriverContext;


public class BasePage {
	
	/** The driver. */
	protected WebDriver driver;

	/** The waiter. */
	protected FluentWait<WebDriver> waiter;

	public static BasePage CurrentPage;
	/**
	 * Instantiates a new base page.
	 * @param driver the driver
	 */
	public BasePage() {
		super();
		driver=WebDriverContext.getDriver();
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}
	
	/*
	 * Scrolling function
	 */
	public WebDriver scrollDownPage(WebDriver driver,int scrollValue)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+scrollValue+")");
		return driver;
	}
	
	/*
	 * Move to particular element and click it
	 */
	public WebDriver hoverTo(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
	    act.moveToElement(element).build().perform();
	    return driver;
	}
}