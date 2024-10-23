package com.ivis.iportal.script;

import com.automation.accelerators.BrowserEngine;
import com.automation.accelerators.ReportHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

public class TestBase {
    public static final ThreadLocal<WebDriver> WEBDRIVER_THREADLOCAL = new ThreadLocal<WebDriver>();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) throws IOException, InterruptedException {
        ReportHelper.createReport(context, "IE", "version", "local", "windows");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "browserVersion", "environment", "platformName"})
    public void beforeClass(String browser, String browserVersion, String environment, String platformName) throws IOException, InterruptedException {
        BrowserEngine testEngine = new BrowserEngine();
        WEBDRIVER_THREADLOCAL.set(testEngine.createBrowser(browser, browserVersion, environment, platformName));
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        WEBDRIVER_THREADLOCAL.get().close();
    }

    @AfterSuite
    public void afterSuite() {
        ReportHelper.closeReport();
    }
}
