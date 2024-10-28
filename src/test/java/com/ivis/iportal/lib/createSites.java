package com.ivis.iportal.lib;

import com.automation.accelerators.ActionEngine;
import com.automation.accelerators.CommonUtils;
import com.ivis.iportal.page.SitesPage;
import org.openqa.selenium.WebDriver;

import static com.ivis.iportal.page.SitesPage.*;

public class createSites {
    private final WebDriver driver;
    private final ActionEngine action;
    private final CommonUtils commonutils;

    public createSites(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionEngine(driver);
        this.commonutils = new CommonUtils(driver);
    }

    // Method to perform click on Sites
    public void clickSites() throws Throwable {
        action.click(sitesClick,"Sites");
    }
    public void addSites(String customerName,String project, String siteGroup) throws Throwable {
        action.click(addSites,"Add Sites");
        action.type(SitesPage.customerName, customerName, "Customer Name");
        action.type(SitesPage.project,project, "ProjectName");
        action.type(SitesPage.siteGroup,siteGroup, "SiteGroupName");
    }
}
