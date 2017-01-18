package com.demo.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by wenhj1 on 2016/12/29.
 */
public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
//        打开浏览器
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void clickTest() throws InterruptedException {
//        打开百度
        driver.get("http://www.baidu.com");
//        定位百度一下按钮
        WebElement baidubutton = driver.findElement(By.id("su"));
//        实例化Actions类
        Actions actions = new Actions(driver);
//        点击百度一下按钮
        actions.contextClick(baidubutton).perform();
        Thread.sleep(5000);
//        双击百度一下按钮
        actions.doubleClick(baidubutton).perform();
    }

    @Test
    public void elementMoveTest() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.linkText("更多产品"));
        Actions actions = new Actions(driver);
//        模拟移动到“更多产品”选项
        actions.moveToElement(element).perform();
    }

    @Test
    public void dragAndDropTest() {
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
//        拖动对象到x，y轴
        actions.dragAndDropBy(element, 300, 400).perform();
    }

    @Test
    public void moveElementToOtherElement() throws InterruptedException {
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/dragAndDrop.html");
//        定位两个元素
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.xpath("/html/body/h1"));
//        实例化Actions类
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
//        长按住某个对象并移动到另一处
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
    }

    @Test
    public void multiplyTest() throws InterruptedException {
//        打开测试用例(测试多选）
        driver.get("file:///C:/Users/wenhj1/Downloads/selenium_html/selenium_html/index.html");
//        定位多选下拉框
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
//        实例化Actions类
        Actions actions = new Actions(driver);
//        定位其中的选项（层级定位）
        List<WebElement> options = element.findElements(By.tagName("option"));
//        模拟按下，并点击选取(里面没有字母和数字选项）
        actions.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).perform();
        Thread.sleep(5000);
    }

    @Test
    public void robotTest() throws AWTException {
        driver.get("https://www.baidu.com/");
//        实例化Robot类
        Robot robot = new Robot();
//        模拟点击按键0
        robot.keyPress(KeyEvent.VK_0);
//        模拟松开按键0
        robot.keyRelease(KeyEvent.VK_0);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
//        另一种方法（强制转换）
        int s = (int) new Character('s');
        robot.keyPress(s);
        robot.keyRelease(s);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
    }

    @Test
    public void uploadTest() {
//        打开测试用例
        driver.get("C:\\Users\\kola\\Documents\\Tencent Files\\282156710\\FileRecv\\selenium_html\\index.html");
//        模拟点击上传按钮并传入文件
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\kola\\Documents\\Tencent Files\\282156710\\FileRecv\\selenium_html/index.html");
    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
//        关闭
        driver.quit();
    }
}
