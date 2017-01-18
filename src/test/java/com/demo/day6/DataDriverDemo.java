package com.demo.day6;


import com.demo.day5.LoginDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kola on 2017/1/13.TestNG数据驱动
 */
public class DataDriverDemo {
  @DataProvider(name = "data1")
  public Object[][] testDataDriver(){
   return new Object[][]{{"X","Y"},{"X","X"},{"Y","Y"}};
  }
  @Test(dataProvider = "data1")
  public void setTestData(String userName,String pwd){
    System.out.println(userName);
    System.out.println(pwd);
  }
  @DataProvider(name = "data2")
  public Object[][]testDataDriver2(){
    return new  Object[][]{{"wenhj123456789","skythebest1991"},{"sss","ssss"},{"wenhj123456789","22222"}};
}
@Test(dataProvider = "data2")
  public void testLogin(String userName,String pwd) throws InterruptedException {
  WebDriver driver=new FirefoxDriver();
  driver.get("http://mail.163.com");
  LoginDemo.login(driver,userName,pwd);
  Thread.sleep(5000);
  driver.quit();
  }


  }

