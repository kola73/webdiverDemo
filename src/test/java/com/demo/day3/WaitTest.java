package com.demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by kola on 2016/12/21.
 */
public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void waitTest1() throws InterruptedException {
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
//        找到对象，点击
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
//        线程等待（sleep一般用于警告框和下载，其他界面不建议使用，会拖慢进度）
        Thread.sleep(5000);
//        获取文本
       String text= driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
//       校验
        Assert.assertEquals(text,"wait for display");
    }
    @Test
    public void waitTest2() throws InterruptedException {
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
//        找到对象，点击
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
//        全局等待(一旦等到想要的对象出现，立刻执行下一步）
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        获取文本
        String text= driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
//       校验
        Assert.assertEquals(text,"wait for display");
    }
    @Test
    public void waitTest3() {
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
//        找到对象，点击
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
//        显示等待(可以等元素加载了再往下操作，推荐！）
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
//        获取文本
        String text= driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
//       校验
        Assert.assertEquals(text,"wait for display");
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
