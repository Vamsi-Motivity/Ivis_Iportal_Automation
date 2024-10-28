package com.ivis.iportal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class sitesPage {
    private WebDriver driver;

    //    public static By sites;
//    public void sitesPage{
//        sites = By.xpath("//span[text()='Sites']");
//
//    }
    public sitesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//span[text()='Sites']")
    WebElement sitesClick;
    @FindBy(xpath = "(//div[@class='d-flex']//*[name()='svg'][1]//*[name()='path' and contains(@fill,'currentCol')][1])[1]")
    WebElement addSites;
    @FindBy(xpath = "(//input[@id='tags-outlined'])[1]")
    WebElement customerName;
    @FindBy(xpath = "(//input[@id='tags-outlined'])[2]")
    WebElement project;
    @FindBy(xpath = "(//input[@id='tags-outlined'])[3]")
    WebElement siteGroup;

    public void clickSites(){
        sitesClick.click();
    }
    public void addSites(){
        addSites.click();
        customerName.click();
        customerName.sendKeys("CBI-Branches");
        project.click();
        project.sendKeys("CBI-Branches");
        siteGroup.click();
        siteGroup.sendKeys("");




    }



}
