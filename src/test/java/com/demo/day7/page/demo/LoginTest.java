package com.demo.day7.page.demo;

import com.demo.day5.LoginDemo;
import day7.po.loginPODemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by kola on 2017/1/3.
 */
public class LoginTest {
     public WebDriver driver;
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://mail.163.com");
    }

     @Test
   public void loginTest1(){
     LoginDemo.login(driver,"wenhj123456789","skythebest1991");
       boolean a= driver.findElement(By.linkText("退出")).isDisplayed();
        Assert.assertTrue(a);
        String name=driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div/div/div[2]/div[2]/span[1]/span[1]")).getText();
        Assert.assertEquals("wenhj123456789",name);
    }

}
