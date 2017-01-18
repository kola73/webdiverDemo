package com.demo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by wenhj1 on 2017/1/5.
 */
public class SendEmailTest extends BaseTest {
    @Test
    public void sendEmail() throws InterruptedException {
//        最大化浏览器
        driver.manage().window().maximize();
//        driver控制权转交给iframe
        driver.switchTo().frame("x-URS-iframe");
//        输入账号密码，点击登录
        driver.findElement(By.name("email")).sendKeys("wenhj123456789");
        driver.findElement(By.name("password")).sendKeys("skythebest1991");
        driver.findElement(By.id("dologin")).click();
//        点击写信
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
//        遍历数组，跳转到下一页
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
//        点击输入收件名
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("282156710@qq.com");
//        输入标题
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("test");
//        传入图片
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Hydrangeas.jpg");
       WebElement element=driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.xpath("html/body")).sendKeys("1111");
        driver.switchTo().defaultContent();
//        发送
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
//        校验是否发送成功
       String element1= driver.findElement(By.xpath(".//*[@id='dvContainer']/div[2]/div[2]/section/h1")).getText();
        Assert.assertEquals("",element1);
    }

}
