package com.ivis.iportal.script;

import com.automation.accelerators.ReportHelper;
import com.ivis.iportal.lib.createSites;
import com.ivis.iportal.lib.loginLib;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class TC_IportalAutomation extends TestBase {
    public static String file_location = System.getProperty("user.dir") + "\\Resources\\IvisUnitConfiguration.xlsx";

    public Object[][] arrObj;

    public HashMap<String, String> map = new HashMap<String, String>();

    @DataProvider(parallel = false)
    public Object[][] loginValidation() throws IOException {
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        arrObj = getExcelData(file_location, "Userlogin");
        return arrObj;
    }
  /*  @DataProvider(parallel = false)
    public Object[][] sitesCreationPage() throws IOException {
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        arrObj = getExcelData(file_location, "Sites");
        return arrObj;
    }*/

    @Test(priority = 0, dataProvider = "loginValidation")
    public void iportalLoginValidation(String url, String runmode, String user, String pass, String invalidpass, String customerName,String project, String siteGroup) throws Throwable {
        try {
            if (runmode.equalsIgnoreCase("Yes")) {

                ReportHelper.createTest("Test_" + url, "For User" + user);
                loginLib lb = new loginLib(WEBDRIVER_THREADLOCAL.get());
                createSites cs = new createSites(WEBDRIVER_THREADLOCAL.get());
                lb.invalidLogin(url, user, invalidpass);
                lb.validLogin(url, user, pass);
                cs.clickSites();
                cs.addSites(customerName, project, siteGroup);
                System.out.println("test methods executed successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  /*  @Test(priority = 1,dataProvider = "loginValidation")
    public void sitesCreationPage(String url, String runmode, String user, String pass, String customerName,String project, String siteGroup) throws Throwable{
        try {
            if (runmode.equalsIgnoreCase("Yes")) {
                //createSites cs = new createSites(WEBDRIVER_THREADLOCAL.get());
                System.out.println("Dead");
                *//*iportalLoginValidation(url, runmode, user, pass);
                cs.clickSites();*//*
                //s.addSites(customerName, project, siteGroup);
                System.out.println("test methods executed successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/


    public synchronized String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;
        try {

            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];

            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
            workbook.close();
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

}
