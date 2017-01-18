package com.demo.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by kola on 2016/12/16.
 */
public class GetTest {
    WebDriver driver;
    @BeforeMethod
  public void openaBrowser(){
      System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.get("http://www.baidu.com");
  }

    @Test
    public void getTagname() {
        //获取TagName
        WebElement element = driver.findElement(By.id("kw"));
        String tagname = element.getTagName();
        //判断是否相等
        Assert.assertEquals(tagname, "input");
    }

    @Test
    public void getAttributeTest() {
//        定位元素
        WebElement element = driver.findElement(By.id("kw"));
//      查找属性
        String attributeTest = element.getAttribute("maxlength");
//        校验
        Assert.assertEquals(attributeTest, "255");

    }
    @Test
    public void displayTest(){
//        定位元素并判断是否显示
       boolean displayTest= driver.findElement(By.id("su")).isDisplayed();
//       校验
       Assert.assertTrue(displayTest);
    }
@Test
public void screenShotTest() throws IOException {

    File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file,new File(".//screenShot//test2.jpg"));
}
    @AfterMethod
    public void closed() {
        driver.quit();
    }


}

