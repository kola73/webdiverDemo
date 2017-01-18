package com.demo.day2;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Element;

/**
 * Created by kola on 2017/1/15.
 */
public class MethodUsage {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
//   打开chrome浏览器
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//   打开百度
        driver.get("http://www.baidu.com");
    }

    @Test
    public void tagNameTest() {
//        定位输入框
        WebElement element = driver.findElement(By.id("kw"));
//        获取TagName
        String tagname = element.getTagName();
        System.out.println(tagname);
        Assert.assertEquals(tagname, "input");
    }

    @Test
    public void getAttributionTest() {
//        定位元素
        WebElement element = driver.findElement(By.id("kw"));
//         获取元素某个属性值
        String att = element.getAttribute("maxlength");
        Assert.assertEquals("255", att);
    }

    @Test
    public void isDisplayTest() {
//         定位元素并判断是否会在页面显示
        boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    @AfterMethod
    public void closed() {
//         关闭窗口
        driver.quit();
    }
}

