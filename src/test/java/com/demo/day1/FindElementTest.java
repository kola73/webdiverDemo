package com.demo.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kola\\Desktop\\webdriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void findElementByID() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        System.out.println(element);
    }

    @Test
    public void findElementByName() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.name("wd"));
        System.out.println(element);
    }

    @Test
    public void findElementByClassName() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.className("s_ipt"));
        System.out.println(element);
    }

    @Test
    public void findElementByLinkText() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.linkText("新闻"));
        System.out.println(element);
    }

    @Test
    public void findElementByPartialLinkText() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.partialLinkText("新"));
        System.out.println(element);
    }

    @Test
    public void findElementByCSS() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.cssSelector("#su"));
        System.out.println(element);
    }

    @Test
    public void findElementByTagName() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.tagName("input"));
        System.out.println(element);
    }

    @Test
    public void search() {
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("123");
    }

    @Test
    public void findElementByXpath() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"form\"]/span[1]"));
        System.out.println(element);
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
