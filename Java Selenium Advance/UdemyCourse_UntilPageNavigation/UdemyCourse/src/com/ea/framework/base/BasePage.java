package com.ea.framework.base;

import org.openqa.selenium.support.PageFactory;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverContext.Driver, this);
    }
}