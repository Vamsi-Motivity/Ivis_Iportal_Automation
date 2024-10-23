package com.automation.accelerators;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportHelper {

    protected static ExtentReports extentReport;
    protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    //@BeforeSuite
    public static void createReport(ITestContext context, String browser, String browserVersion, String environment, String platformName) {
        String currentDateTime = CommonUtils.timestamp();
        String reportName = context.getSuite().getName() + " Test Report";
        //String reportPath = System.getProperty("user.dir") + "/test-output/" + reportName + ".html";
        String reportPath = System.getProperty("user.dir") + "/test-output/" + reportName + currentDateTime + ".html";

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("Browser", browser);
        extentReport.setSystemInfo("Browser Version", browserVersion);
        extentReport.setSystemInfo("Host Name", "localhost");
        extentReport.setSystemInfo("Environment", environment);
        extentReport.setSystemInfo("Platform Name", platformName);
    }

    public static void createTest(String testname, String description) {
        extentTest.set(extentReport.createTest(testname, description));
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void log(Status status, String message) {
        extentTest.get().log(status, message);
    }

    public static void log(Status status, String message, String filePath) throws IOException {
        extentTest.get().log(status, message);
        //extentTest.get().log(status, (Markup) MediaEntityBuilder.createScreenCaptureFromBase64String(FileOpsHelper.encodeFileToBase64Binary(filePath)).build());
    }

    //@AfterSuite
    public static void closeReport() {
        extentReport.flush();
    }

    public static void createTest(String browser) {
        // TODO Auto-generated method stub

    }

    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;

    }

}

