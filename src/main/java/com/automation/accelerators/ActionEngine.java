package com.automation.accelerators;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionEngine {

    private final Logger LOG = Logger.getLogger(ActionEngine.class);
    public int sleep = 2000;
    private final WebDriver driver;

    public ActionEngine(WebDriver driver) {
        this.driver = driver;
    }

    public boolean type(By locator, String testdata, String locatorName) throws Throwable {

        boolean status = false;
        try {

            driver.findElement(locator).clear();
            //Thread.sleep(sleep);
            driver.findElement(locator).sendKeys(testdata);
            ReportHelper.log(Status.PASS, "Enter Text in " + locatorName);
            status = true;
        } catch (Exception e) {
            status = false;
            LOG.info(e.getMessage());
            String filePath = ReportHelper.getScreenShot(driver, locatorName);
            ReportHelper.log(Status.FAIL, "Unable to Enter Text in " + locatorName, filePath);
        }

        return status;
    }

    public boolean clickUsingJavascriptExecutor(By locator, String locatorName)
            throws Throwable {
        boolean flag = false;
        try {

            WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            //Thread.sleep(2000);
            flag = true;
            System.out.println("clicked " + locatorName);
        } catch (Exception e) {

        } finally {
            if (!flag) {
                ReportHelper.log(Status.FAIL, "unable to clicked on" + locatorName);

                return true;
            } else {
                ReportHelper.log(Status.PASS, "Successfully clicked on" + locatorName);

            }
        }
        return flag;
    }


    public boolean click(By locator, String locatorName) throws Throwable {
        boolean status = false;
        try {
            driver.findElement(locator).click();
            ReportHelper.log(Status.PASS, "Successfully clicked on " + locatorName);
            status = true;
        } catch (Exception e) {
            status = false;
            LOG.info(e.getMessage());
            String filePath = ReportHelper.getScreenShot(driver, locatorName);
            ReportHelper.log(Status.FAIL, "Unable to click on " + locatorName, filePath);
        }
        return status;

    }

}
