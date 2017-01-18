package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2016/12/16.
 */
public class SelectTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
    }

    @Test
    public void selectTest() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//        点击弹框
        element.click();
//        判断是否被选中
        boolean isselected = element.isSelected();
//        校验
        Assert.assertTrue(isselected);
    }

    @Test
    public void isEnabledTest() {
//        定位并获取文本是否可输入
        boolean isEnabled = driver.findElement(By.name("buttonhtml")).isEnabled();
//            校验
        Assert.assertFalse(isEnabled);
    }

    @Test
    public void selectTest1() {
//            定位下拉框
        WebElement element = driver.findElement(By.id("moreSelect"));
//            实例化一个select类
        Select select = new Select(element);
//            通过索引选取下拉框
        select.selectByIndex(4);
//        通过属性value来选取下拉框
        select.selectByValue("meizu");
//        通过文本来选取下拉框
        select.selectByVisibleText("xiaomi");
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
