package com.demo.day5;

import day7.po.loginPODemo;
import day7.po.registerPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/2.
 * 手机验证码错误的Case
 */
public class Register163AccountTest extends BaseTest {
    //    获得13位的时间戳
    long time = System.currentTimeMillis();

    @Test
    public void createUser() {
//        打开163邮箱首页
        driver.get("http://mail.163.com/");
//        把控制权转交给iframe(PO模式下）
        WebElement frame = driver.findElement(loginPODemo.iframe);
        driver.switchTo().frame(frame);
//        点击立即注册
        driver.findElement(By.id("changepage")).click();
//        控制权转交到新页面
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handle1.equals(handles)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
//        点击注册字母邮箱
        driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a")).click();
/*      定位邮件地址并赋值(这里的值是用时间戳的值，因为sendkeys不支持long类型，故这里强制转换为其他类型）
    （PS:因为系统会唯一标识，已经注册的账号就无法使用，故目前有2种处理方法：
     1，跑case前先备份数据，跑完后再还原2.把账号变为随机数（时间戳））*/
        driver.findElement(registerPO.rmail).sendKeys("e" + String.valueOf(time));
//       定位密码输入框并赋值
        driver.findElement(registerPO.rpwd).sendKeys("qazxsw123");
//        定位确认密码框并赋值
        driver.findElement(registerPO.rpwd2).sendKeys("qazxsw123");
//        定位手机号码框并赋值(强制转换数据类型并把13位的时间戳变为11位）
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time / 100));
//        定位验证码（两种解决方式：1.让开发提供万能验证码 2.去掉验证码逻辑）
        driver.findElement(By.id("vcodeIpt")).sendKeys("123456");
//        输入短信验证码（解决方法同上）
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("112344");
//        点击注册按钮
        driver.findElement(By.id("mainRegA")).click();
//        校验是否有出现验证码错误的提示
      String error=  driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");
    }
}