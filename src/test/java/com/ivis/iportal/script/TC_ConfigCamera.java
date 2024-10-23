package com.ivis.iportal.script;

import com.automation.accelerators.ReportHelper;
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

public class TC_ConfigCamera extends TestBase {
    public static String file_location = System.getProperty("user.dir") + "\\Resources\\IvisUnitConfiguration.xlsx";

    public Object[][] arrObj;

    public HashMap<String, String> map = new HashMap<String, String>();

    @DataProvider(parallel = true)
    public Object[][] loginValidation() throws IOException {
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        arrObj = getExcelData(file_location, "Userlogin");
        return arrObj;
    }

    @Test(priority = 0, dataProvider = "loginValidation")
    public void iportalLoginValidation(String url, String runmode, String user, String pass) throws Throwable {
        try {
            if (runmode.equalsIgnoreCase("Yes")) {

                ReportHelper.createTest("Test_" + url, "For User" + user);
                // https://www.lambdatest.com/blog/extent-reports-in-selenium/
                loginLib lb = new loginLib(WEBDRIVER_THREADLOCAL.get());
                System.out.println("iPortal loggedin successfully");
                lb.testLogin(url, user, pass);
                //lb.invalidLogin(url, user, pass);
                System.out.println("iPortal loggedin successfully2");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 1, dataProvider = "iviscameralinkautomation")
    public void ivisautomationurlexecution(String url, String deviceid) throws Throwable {
        try {

            // System.out.println("The thread ID for chrome is "+
            // Thread.currentThread().getId());
            ReportHelper.createTest("Test_" + url);
            // https://www.lambdatest.com/blog/extent-reports-in-selenium/
            loginLib lb = new loginLib(WEBDRIVER_THREADLOCAL.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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
