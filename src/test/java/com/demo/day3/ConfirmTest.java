package com.demo.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class ConfirmTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void ConfirmTestDemo() throws InterruptedException {
        //        打开地址
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/index.html");
        //        定位并点击button按钮
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(3000);
        //        driver控制权转给alert弹窗
        Alert alert = driver.switchTo().alert();
        //        点击取消
        alert.dismiss();
        //        点击确认
        alert.accept();
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}

