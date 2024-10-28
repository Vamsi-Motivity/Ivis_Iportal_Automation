package com.ivis.iportal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SitesPage {
    private WebDriver driver;

    // Define locators as static variables
    public static By sitesClick;
    public static By addSites;
    public static By customerName;
    public static By project;
    public static By siteGroup;

    // Initialize locators in a method
    public void initializeLocators() {
        sitesClick = By.xpath("//span[text()='Sites']");
        addSites = By.xpath("(//div[@class='d-flex']//*[name()='svg'][1]//*[name()='path' and contains(@fill,'currentCol')][1])[1]");
        customerName = By.xpath("(//input[@id='tags-outlined'])[1]");
        project = By.xpath("(//input[@id='tags-outlined'])[2]");
        siteGroup = By.xpath("(//input[@id='tags-outlined'])[3]");
    }

}
