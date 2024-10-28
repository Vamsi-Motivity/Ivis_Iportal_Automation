package com.ivis.iportal.page;

import org.openqa.selenium.By;

public class UnitsPage {
    public static By unitsmodule;
    public static By addicon;
    public static By customernamedropdownfield;
    public static By sitenamedropdown ;
    public static By salesstagedropdown ;
    public static By unitnametextfield ;
    public static By unittextfield ;







    public void loginPage() {

        unitsmodule = By.xpath("//span[text()='Units']");
        addicon = By.xpath("//div[@class='d-flex flex-direction-column']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
        customernamedropdownfield=By.xpath("//span[text()='Select Customer Name']");
       sitenamedropdown =By.xpath("//span[text()='Select Site Name']");
        salesstagedropdown=By.xpath("//input[@id='salesStage']");
        unitnametextfield= By.xpath("//input[@id='unitName']");
        //div[@class='MuiSelect-select MuiSelect-filled MuiInputBase-input MuiFilledInput-input jss125 Mui-readOnly MuiInputBase-readOnly css-17gq4vl']




    }

}
