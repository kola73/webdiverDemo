package com.demo.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
//                打开地址
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/index.html");
    }

    @Test
    public void alertTestdemo() throws InterruptedException {
//              定位并点击button按钮
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(3000);
//               driver控制权移交给alert弹窗（建议弹窗处理前加上等待,避免因为脚本执行过快而报错）
        Alert alert = driver.switchTo().alert();
        //        获取弹框文本
        String text = alert.getText();
        //        校验是否相等
        Assert.assertEquals(text, "请点击确定");
        //        处理确定
        alert.accept();
    }

    @AfterMethod
    public void closed() {
        driver.quit();
    }
}
