package com.demo.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class BrowserActionTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowers() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    public void test2() {
        driver.get("http://www.baidu.com");
        driver.get("http://www.imooc.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void test3() {
        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
    }

    @Test
    public void test4() {
        driver.get("https://www.baidu.com/");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals("https://www.baidu.com/", url);
    }

    @Test
    public void testTitle() {
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println("百度的title为：" + title);
        Assert.assertEquals("百度一下，你就知道", title);
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}

