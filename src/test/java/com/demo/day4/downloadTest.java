package com.demo.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Created by kola on 2016/12/31.
 */
public class downloadTest {
    WebDriver driver;

    @BeforeMethod
    public void openIEBrowser() {
//        打开IE浏览器
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    @Test
    public void downloadTest() throws AWTException {
//        打开下载页面
        driver.get("http://rj.baidu.com/soft/detail/35013.html?ald");
//        点击下载
        driver.findElement(By.className("normal_download")).click();
//        实例化Robot类
        Robot robot = new Robot();
//        点击alt+s键保存文件
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
    }

    @AfterMethod
    public void closed() {
//        关闭浏览器
        driver.quit();
    }

}