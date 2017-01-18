package com.demo.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2016/12/20.
 * prompt提示框
 */
public class PromptTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.firefoxdriver.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
    }

    @Test
    public void promptTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
        Alert prompt = driver.switchTo().alert();
        Thread.sleep(3000);
        prompt.sendKeys("这是个prompt");
        Thread.sleep(3000);
        prompt.accept();
        prompt.accept();
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
