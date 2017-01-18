package com.demo.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by kola on 2017/1/15.
 */
public class ScreenShotTest {
    WebDriver driver;

    @BeforeMethod
//            打开chrome
    public void opneBrowser() {
        System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
        driver = new ChromeDriver();
//            打开自动化用例
        driver.get("C:\\Users\\wenhj1\\Downloads\\selenium_html\\selenium_html\\index.html");
    }

    @Test
    public void screenshotTest() throws IOException {
//          截图
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("D:/TEST2.PNG"));
    }
}


