package com.automation.accelerators;

import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonUtils {

    private final Logger LOG = Logger.getLogger(ActionEngine.class);
    public int sleep = 2000;
    private final WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static String getCurrentDate(String dateFormat) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        //LocalDate tomorrow = today.plusDays(noOfDays);
        return formatter.format(today);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public void wait(long delaytime, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(delaytime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean searchFirstElement(By locator, long delaytime, String locatorName) throws Throwable {

        boolean status = false;
        try {
            WebDriverWait elementvisibilitywait = new WebDriverWait(driver, Duration.ofMinutes(delaytime));
            elementvisibilitywait.until(ExpectedConditions.presenceOfElementLocated(locator));
            //driver.findElement(locator).getTagName();
            ReportHelper.log(Status.PASS, "Website loaded successfully");
            status = true;
        } catch (Exception e) {
            status = false;
            LOG.info(e.getMessage());
//        ReportHelper.log(Status.FAIL,"Enter Text in "+locatorName);
            String filePath = ReportHelper.getScreenShot(driver, locatorName);
            ReportHelper.log(Status.FAIL, "Unable to locate the locator " + locatorName, filePath);
            // reporter.failureReport("Enter text in "+locatorName, msgTypeFailure + locatorName, Driver);
        }

        return status;
    }

    public void scrollIntoView(By strLocator) throws InterruptedException {
        WebElement element = driver.findElement(strLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Thread.sleep(2000);
    }

    public void selectDropdownOption(By strLocator, String strOption, String strlabel) throws IOException {
        try {
            WebElement dpbxEle = driver.findElement(strLocator);
            Select objSelect = null;
            moveToElement(dpbxEle);
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(dpbxEle));
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(dpbxEle));
            //for (int i = 0; i < 15; i++) {
            try {
                objSelect = new Select(dpbxEle);
                objSelect.selectByValue(strOption);
                //break;
            } catch (Exception exe) {
                System.out.println("failed to select dropdown: " + strlabel);
                //Thread.sleep(sleep);
            }

        } catch (Exception e) {
            e.printStackTrace();
            ReportHelper.log(Status.FAIL, "Select dropdown option from " + strlabel,
                    "'" + strOption + "' is not selected from " + strlabel + " dropdown");

        }
    }

    public void moveToElement(WebElement dpbxEle) {
        try {
            new Actions(driver).moveToElement(dpbxEle).perform();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean searchTextElement(By locator, long delaytime, String locatorName) throws Throwable {

        boolean status = false;
        try {
            WebDriverWait elementvisibilitywait = new WebDriverWait(driver, Duration.ofMinutes(delaytime));
            elementvisibilitywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ReportHelper.log(Status.PASS, "Element was located");
            status = true;
        } catch (Exception e) {
            status = false;
            LOG.info(e.getMessage());
//	        ReportHelper.log(Status.FAIL,"Enter Text in "+locatorName);
            String filePath = ReportHelper.getScreenShot(driver, locatorName);
            ReportHelper.log(Status.FAIL, "Unable to find the locator " + locatorName, filePath);
            // reporter.failureReport("Enter text in "+locatorName, msgTypeFailure + locatorName, Driver);
        }

        return status;
    }

    public boolean searchClickElement(By locator, long delaytime, String locatorName) throws Throwable {

        boolean status = false;
        try {
            WebDriverWait elementvisibilitywait = new WebDriverWait(driver, Duration.ofMinutes(delaytime));
            elementvisibilitywait.until(ExpectedConditions.elementToBeClickable(locator));
            ReportHelper.log(Status.PASS, "Element was located");
            status = true;
        } catch (Exception e) {
            status = false;
            LOG.info(e.getMessage());
//	        ReportHelper.log(Status.FAIL,"Enter Text in "+locatorName);
            String filePath = ReportHelper.getScreenShot(driver, locatorName);
            ReportHelper.log(Status.FAIL, "Unable to find the locator " + locatorName, filePath);
            // reporter.failureReport("Enter text in "+locatorName, msgTypeFailure + locatorName, Driver);
        }

        return status;
    }

}
