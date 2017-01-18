package com.demo.day6;

import org.apache.tools.ant.taskdefs.ExecuteJava;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by wenhj1 on 2017/1/10.
 * 适用于如前端不让一口气输入字符（无法使用sendkeys）或者限制字符（如规定只能输入11位，但是我们需要输入12位）
 */
public class JSTest1 {
    @Test
    public void testJS() throws InterruptedException {
//        打开浏览器
        System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        打开百度
        driver.get("http://www.baidu.com");
//        执行JS脚本(强制转换）
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        在搜索框输入sdd(在火狐浏览器写完以后直接复制）
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"sdd\")");
//        在控制台输出cola
        js.executeScript("console.log(\"cola\")");
        Thread.sleep(5000);
//        关闭浏览器
        driver.quit();
       
    }

}
