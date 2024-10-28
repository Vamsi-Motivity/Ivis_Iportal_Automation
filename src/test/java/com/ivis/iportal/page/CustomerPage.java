package com.ivis.iportal.page;

import org.openqa.selenium.By;
public class CustomerPage {
    public static By customerMenu;
    public static By createButton;
    public static By customerName;
    public static By country;
    public static By fax;
    public static By customerCode;
    public static By state;
    public static By industry;
    public static By email;
    public static By city;
    public static By website;
    public static By street;
    public static By leadNumber;
    public static By phoneNumber;
    public static By address;
    public static By type;
    public  static By description;
    public static By zipCode;

    public void customerPage() {
        customerMenu = By.xpath("//a[@aria-label='Customers']");
        createButton = By.cssSelector("svg[aria-label='Add Customer']");
        customerName = By.xpath("//input[@id='customerName']");
        country = By.xpath("//label[@for='country']/following-sibling::div/div/div/div");
        fax = By.xpath("//input[@id='fax']");
        customerCode = By.xpath("//input[@id='customerCode']");
        state = By.xpath("//label[@for='state']/following-sibling::div/div/div/div");
        industry = By.xpath("//label[@for='customerIndustryType']/following-sibling::div/div/div/div");
        email = By.xpath("//input[@id='email']");
        city = By.xpath("//label[@for='city']/following-sibling::div/div/div/div");
        website = By.xpath("//input[@id='website']");
        street = By.xpath("//input[@id='customerStreet']");
        leadNumber = By.xpath("//input[@id='leadNo']");
        phoneNumber = By.xpath("//input[@id='phoneNo']");
        address = By.xpath("//textarea[@id='address']");
        type = By.xpath("//label[@for='type']/following-sibling::div/div/div/div/div[@id='type']");
        description = By.xpath("//textarea[@id='description']");
        zipCode = By.xpath("//input[@id='customerZipCode']");
    }
}
