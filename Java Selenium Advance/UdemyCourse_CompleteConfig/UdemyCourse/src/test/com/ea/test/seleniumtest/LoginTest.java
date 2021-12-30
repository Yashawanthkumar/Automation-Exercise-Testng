package com.ea.test.seleniumtest;

import com.ea.framework.base.BrowserType;
import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.ConfigReader;
import com.ea.framework.config.Settings;
import com.ea.framework.utilities.DatabaseUtil;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.framework.utilities.LogUtil;
import com.ea.framework.utilities.ReportingUtil;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Karthik-PC on 11/24/2016.
 */
public class LoginTest extends FrameworkInitialize {


    @Before
    public void Initialize() throws IOException {


        ConfigReader.PopulateSettings();

        Connection reportConn = DatabaseUtil.Open(Settings.ReportingConnectionString);
        ReportingUtil.CreateTestCycle(reportConn);


        Connection conn = DatabaseUtil.Open(Settings.AUTConnectionString);

        DatabaseUtil.ExecuteQuery("SELECT * FROM Employees", conn);


        LogUtil logutil = new LogUtil();
        logutil.CreateLogFile();
        logutil.Write("Framework Initialize");

        InitializeBrowser(Settings.BrowserType);
        DriverContext.Browser.GoToUrl(Settings.AUT);

        try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (Exception e) {
        }

    }

    @Test
    public void Login() throws InterruptedException {

        /*driver.findElement(By.name("UserName")).sendKeys("admin");
        _driver.findElement(By.name("Password")).sendKeys("admin");
        _driver.findElement(By.name("Login")).submit();*/

        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).ClickLogin();

        Thread.sleep(2000);
        //Hardcoded
        //CurrentPage.As(LoginPage.class).Login("admin", "password");

        //DDT from Excel
        CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("UserName", 1), ExcelUtil.ReadCell("Password", 1));
    }

}
