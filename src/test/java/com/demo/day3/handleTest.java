package com.demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2016/12/21.
 */
public class handleTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void handleTestDemo() throws InterruptedException {
        driver.get("file:///C:/Users/kola/Documents/Tencent%20Files/282156710/FileRecv/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
//        获取当前win的句柄
        String handles1 = driver.getWindowHandle();
//        获取所有win的句柄，并与handles1逐个匹配。匹配成功表示还在当前界面，继续匹配。直到不一样，就表示进入下一页，然后直接转交window窗口
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handles1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        Thread.sleep(3000);
        driver.findElement(By.id("user")).sendKeys("new window");
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
