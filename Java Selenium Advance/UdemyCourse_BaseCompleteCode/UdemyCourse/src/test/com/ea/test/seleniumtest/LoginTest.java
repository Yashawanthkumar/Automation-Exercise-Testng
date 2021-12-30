package com.ea.test.seleniumtest;

import com.ea.framework.base.BrowserType;
import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Karthik-PC on 11/24/2016.
 */
public class LoginTest extends FrameworkInitialize {


    @Before
    public void Initialize() {
        InitializeBrowser(BrowserType.Firefox);
        DriverContext.Browser.GoToUrl("http://localhost:64429/");
    }

    @Test
    public void Login() throws InterruptedException {

        /*driver.findElement(By.name("UserName")).sendKeys("admin");
        _driver.findElement(By.name("Password")).sendKeys("admin");
        _driver.findElement(By.name("Login")).submit();*/

        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).ClickLogin();

        Thread.sleep(2000);
        CurrentPage.As(LoginPage.class).Login("admin", "password");
    }
}
