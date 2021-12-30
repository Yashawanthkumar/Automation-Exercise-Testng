package com.ea.framework.base;

import org.openqa.selenium.support.PageFactory;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public class Base {

    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page)
    {
        Object obj = PageFactory.initElements(DriverContext.Driver, page);
        return page.cast(obj);
    }
}
