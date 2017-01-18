package com.demo.day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/10.(没有界面的浏览器，优点：速度快，适用于写爬虫，可节省部分时间）
 */
public class PhantomJSTest {
    @Test
    public void testPhantom(){
        System.setProperty("phantomjs.binary.path",".//drivers//phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://www.baidu.com");
//        输出标题
       System.out.println(driver.getTitle());
//       因为程序会有遗留在后台，故建议关闭
       driver.quit();
    }
}
