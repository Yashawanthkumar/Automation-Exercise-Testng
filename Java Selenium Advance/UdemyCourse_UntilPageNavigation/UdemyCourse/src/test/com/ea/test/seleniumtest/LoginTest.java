package com.ea.test.seleniumtest;

import com.ea.framework.base.DriverContext;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Karthik-PC on 11/24/2016.
 */
public class LoginTest {

    @Before
    public void Initialize()
    {
        //Open the browser
        System.setProperty("webdriver.gecko.driver", "c:\\lib\\geckodriver.exe");
        DriverContext.Driver = new FirefoxDriver();
        DriverContext.Driver.navigate().to("http://localhost:64429");
    }


    @Test
    public void Login() throws InterruptedException {

        /*driver.findElement(By.name("UserName")).sendKeys("admin");
        _driver.findElement(By.name("Password")).sendKeys("admin");
        _driver.findElement(By.name("Login")).submit();*/

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.ClickLogin();

        Thread.sleep(2000);

        loginPage.Login("admin", "password");
   }
}
