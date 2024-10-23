package com.ivis.iportal.lib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class validationscreenshot {
    public static String filename;
    public static String file_location = System.getProperty("user.dir") + "\\Resources\\" + filename + ".xlsx";
    ArrayList<String> threadsName = new ArrayList<String>();
    private final WebDriver driver;

    public validationscreenshot(WebDriver driver) {
        this.driver = driver;

    }

    public static String getValidationScreenShot(WebDriver driver, String deviceid, String screenshotName) throws IOException {

        //String folderpath = System.getProperty("user.dir") + "/Screenshots/";
        File foldername = new File(deviceid);
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        foldername.mkdir();
        String destination = System.getProperty("user.dir") + "/" + deviceid + "/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;

    }


}
