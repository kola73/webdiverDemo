package com.demo.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kola on 2017/1/15.
 * 查找多个元素
 */
public class FindElements {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void findElementsByXpath() {
        driver.get("http://www.baidu.com");
        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < webElements.size(); i++) {
            String text = webElements.get(i).getText();
            System.out.println(text);
        }
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

