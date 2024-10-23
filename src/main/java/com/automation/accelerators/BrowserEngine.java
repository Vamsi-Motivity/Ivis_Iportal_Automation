package com.automation.accelerators;

import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserEngine {
    public final Logger LOG = Logger.getLogger(BrowserEngine.class);

    private WebDriver driver = null;
    private String browser = null;
    private String version = null;
    private String platform = null;
    private String environment = null;

    public WebDriver createBrowser(String browser, String browserVersion, String environment, String platformName) throws IOException, InterruptedException {

        this.browser = browser;
        this.version = browserVersion;
        this.environment = environment;
        this.platform = platformName;


        if (environment.equalsIgnoreCase("local")) {
            setWebDriverForLocal(browser);
        }
        return driver;

    }

    private WebDriver setWebDriverForLocal(String browser) throws IOException, InterruptedException {
        switch (browser) {

            case "chrome":

                System.out.println("TestCase runs in Chrome");
                String chromeDriverfilelocation = System.getProperty("user.dir") + "\\Resources\\Chromedriver\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeDriverfilelocation);
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments("--remote-allow-origins=*");
                chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver(chromeoptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

        }
        return driver;
    }


}
