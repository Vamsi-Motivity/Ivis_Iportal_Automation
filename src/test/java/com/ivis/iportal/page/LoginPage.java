package com.ivis.iportal.page;

import org.openqa.selenium.By;

public class LoginPage {
    public static By userName;
    public static By password;
    public static By loginBtn;
    public static By invaliErrorMessage;

    public void loginPage() {

        userName = By.xpath("//*[@id='loginId']");
        password = By.xpath("//*[@id='password']");
        loginBtn = By.xpath("//button[@type='submit']");
        invaliErrorMessage = By.xpath("//div/p[contains(text(), 'Invalid credentials')]");
    }

}
