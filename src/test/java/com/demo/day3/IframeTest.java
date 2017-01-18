package com.demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void opneBrowser() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/index.html");
    }

    @Test
    public void IframeTest() throws InterruptedException {
        //        把driver控制权转移到iframe（用id或者name定位）
        driver.switchTo().frame("aa");
        //        如果没有name/id，iframe的另一种转交方式如下：
             WebElement element=driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        //       driver.switchTo().frame(element);
//                操作iframe里的元素
            Thread.sleep(3000);
             driver.findElement(By.linkText("baidu")).click();
        //        driver控制权转交给默认页面
           driver.switchTo().defaultContent();
            driver.findElement(By.linkText("登陆界面")).click();}
           @AfterMethod
           public void closed() {
           driver.quit();
         }}
