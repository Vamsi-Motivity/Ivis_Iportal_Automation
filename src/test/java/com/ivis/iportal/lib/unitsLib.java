package com.ivis.iportal.lib;

import com.automation.accelerators.ActionEngine;
import com.automation.accelerators.CommonUtils;
import com.automation.accelerators.ReportHelper;
import com.aventstack.extentreports.Status;
import com.ivis.iportal.page.LoginPage;
import com.ivis.iportal.page.UnitsPage;
import org.openqa.selenium.WebDriver;

public class unitsLib {
    private final WebDriver driver;
    private final ActionEngine action;
    private final CommonUtils commonutils;

    public unitsLib(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionEngine(driver);
        this.commonutils = new CommonUtils(driver);
    }

    public void createCustomer(String addbutton, String customername) throws Throwable {


        commonutils.searchFirstElement(LoginPage.userName, 2, "//span[text()='Units']");
        action.click(UnitsPage.addicon,addbutton);
        action.type(UnitsPage.customernamedropdownfield,customername,customername);


    }
}
