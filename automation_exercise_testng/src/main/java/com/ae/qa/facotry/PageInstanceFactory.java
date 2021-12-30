package com.ae.qa.facotry;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.ae.qa.context.WebDriverContext;
import com.ae.qa.util.BasePage;


public class PageInstanceFactory {
	
	/**
	 * Gets the single instance of PageinstancesFactory.
	 * @param <T> the generic type
	 * @param type the type
	 * @return single instance of PageinstancesFactory
	 */
	
	public static <Tpage extends BasePage> Tpage getInstance(Class<Tpage> type) {
		try {
			return (type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver()));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}