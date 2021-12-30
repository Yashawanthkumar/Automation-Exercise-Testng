package com.ea.test.seleniumtest;

import com.ea.framework.utilities.ExcelUtil;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import com.ea.test.steps.TestInitialize;
import org.junit.Test;

/**
 * Created by Karthik-PC on 11/24/2016.
 */
public class LoginTest extends TestInitialize {

    @Test
    public void Login() throws InterruptedException {
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).ClickLogin();
        Thread.sleep(2000);
        //DDT from Excel
        CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("UserName", 1), ExcelUtil.ReadCell("Password", 1));
    }

}
