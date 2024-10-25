package com.ivis.iportal.lib;

import com.automation.accelerators.ActionEngine;
import com.automation.accelerators.CommonUtils;
import com.automation.accelerators.ReportHelper;
import com.aventstack.extentreports.Status;
import com.ivis.iportal.page.LoginPage;
import org.openqa.selenium.WebDriver;


public class loginLib {

    private final WebDriver driver;
    private final ActionEngine action;
    private final CommonUtils commonutils;

    public loginLib(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionEngine(driver);
        this.commonutils = new CommonUtils(driver);
    }

    public void validLogin(String url, String user, String pwd) throws Throwable {


        new LoginPage().loginPage();
        driver.manage().deleteAllCookies();
        driver.get(url);
        //test commit check
        //test

        ReportHelper.log(Status.PASS, "Navigated To URL" + url);
        //driver.findElement(By.xpath("//div[@class='css-1gsuzdn-inputContainer']/input")).sendKeys(user);
        commonutils.searchFirstElement(LoginPage.userName, 2, "UserName");
        action.type(LoginPage.userName, user, "Username");
        action.type(LoginPage.password, pwd, "Password");
        action.click(LoginPage.loginBtn, "Login Button");
        System.out.println("Login Button clicked");

    }

    public void invalidLogin(String url, String user, String invalidpassword) throws Throwable {

        new LoginPage().loginPage();
        driver.manage().deleteAllCookies();
        driver.get(url);
        ReportHelper.log(Status.PASS, "Navigated To URL" + url);
        //driver.findElement(By.xpath("//div[@class='css-1gsuzdn-inputContainer']/input")).sendKeys(user);
        commonutils.searchFirstElement(LoginPage.userName, 2, "UserName");
        action.type(LoginPage.userName, user, "Username");
        action.type(LoginPage.password, invalidpassword, "Password");
        action.click(LoginPage.loginBtn, "Login Button");
        commonutils.searchTextElement(LoginPage.invaliErrorMessage, 2, "Error message");
        commonutils.checkMessage(LoginPage.invaliErrorMessage, 2);
        System.out.println("invalid login Message id displayed");

    }
}
