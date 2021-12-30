package com.ae.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.ae.qa.context.WebDriverContext;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Every test class should extend this calss.
 *
 * @author Yashawanthkumar
 */

//@Listeners({ReportListener.class, LogListeners.class })
public class BaseTest {
	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LogUtil.info("************************** Test Execution Started ************************************");
		LogUtil.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		TestProperties.loadAllPropertie();
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {

		if (TestProperties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("disable-infobars");
			driver = new ChromeDriver(ops);
		}

		else if (TestProperties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("disable-infobars");
			driver = (WebDriver) new FirefoxOptions(ops);
		}
		driver.get(TestProperties.getProperty("url"));
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverContext.setDriver(driver);
	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {
		if (driver != null) {
			driver.close();
		}
	}

	public String getScreenshotpath(String testCaseName, WebDriver fail_driver) {
		TakesScreenshot ts = (TakesScreenshot) fail_driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		File dest_file = new File(destination);
		try {
			FileUtils.copyFile(source, dest_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}