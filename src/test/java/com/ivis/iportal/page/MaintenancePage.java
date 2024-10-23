package com.ivis.iportal.page;

import org.openqa.selenium.By;

public class MaintenancePage {

    public static By configurationTab;
    public static By systemMenu;
    public static By maintenance;
    public static By deviceParametersBrowseBtn;
    public static By deviceParametersImportBtn;
    public static By maintenanceSaveBtn;
    public static By rebootPopupOkBtn;
    public static By rebootPopupNote;
    public static By fileDecryptPassword;
    public static By firmWareUpgradeBtn;


    public void maintenancePage() {
        configurationTab = By.xpath("//a[@ng-bind='oLan.config' and text()='Configuration']");
        systemMenu = By.xpath("//span[@ng-bind='oMenuLan.system' and text()='System']");
        maintenance = By.xpath("//span[@ng-bind='oMenuLan.maintenance' and text()='Maintenance']");
        deviceParametersBrowseBtn = By.xpath("//button[@ng-click=\"browseFilePath('config')\"]");
        deviceParametersImportBtn = By.xpath("//button[@ng-click='importParam()']");
        maintenanceSaveBtn = By.xpath("//button[contains(@class,'btn-save')]");
        rebootPopupOkBtn = By.xpath("//button[@class='aui_state_highlight']");
        rebootPopupNote = By.xpath("//div[@class='aui_content']");
        fileDecryptPassword = By.xpath("//input[@ng-model='oPassword.szPassword']");
        firmWareUpgradeBtn = By.xpath("//button[@ng-bind='oLan.upgrade']");

    }
}
