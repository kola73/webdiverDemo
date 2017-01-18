package com.demo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by kola on 2017/1/3.
 */
public class LoginTest  {
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
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("wenhj123456789");
        driver.findElement(By.name("password")).sendKeys("skythebest1991");
        driver.findElement(By.id("dologin")).click();
       boolean a= driver.findElement(By.linkText("退出")).isDisplayed();
        Assert.assertTrue(a);
        String name=driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div/div/div[2]/div[2]/span[1]/span[1]")).getText();
        Assert.assertEquals("wenhj123456789",name);
    }
    @Test
    public void FailLoginTest() {
        LoginDemo.login(driver,"wenhj123456789", "skythebest199");
        String c = driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals("帐号或密码错误", c);


    }

}
