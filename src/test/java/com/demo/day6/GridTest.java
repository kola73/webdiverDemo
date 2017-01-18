package com.demo.day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by kola on 2017/1/12.
 */
public class GridTest {
    @Test
    public void testGrid() throws InterruptedException, MalformedURLException {
//        创建一个DesiredCapabilities类型
        DesiredCapabilities chromedc = DesiredCapabilities.chrome();
//        实例化一个driver类(如需随机分配，可直接写hub的地址）
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.104:4449/wd/hub"), chromedc);
        driver.get("http://www.baidu.com");
        Thread.sleep(50000);
        driver.quit();
    }
    @DataProvider(name = "data3")
    public Object[][]testGridDemo(){
        return new Object[][]{
                {"http://192.168.1.104:4449","chrome"},
                {"http://192.168.1.104:5657","firefox"}};
    }
    @Test(dataProvider = "data3")
    public void testGrid1(String url,String browser) throws MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser=="chrome"){
            dc=DesiredCapabilities.chrome();
        }else if (browser=="firefox"){
            dc=DesiredCapabilities.firefox();
        }else {
            System.out.println("error");
        }
        WebDriver driver =new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        driver.quit();
    }

    }
