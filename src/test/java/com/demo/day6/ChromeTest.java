package com.demo.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by wenhj1 on 2017/1/10.(设置chrome,firefox的下载路径,因为软件不断迭代，有些设置会失效）
 */
public class ChromeTest {
    public WebDriver driver;

    @Test
    public void test1() {
//        设置下载路径为D盘
        String downloadFilepath = "D:\\";
//        哈希表配置参数
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        配置不弹窗
        chromePrefs.put("prefile.default_content_settings.popups", 0);
//        设置下载文件的路径
        chromePrefs.put("download.default_directory", downloadFilepath);
//        实例化类
        ChromeOptions options = new ChromeOptions();
//        调用方法传入哈希表参数
        options.setExperimentalOption("prefs", chromePrefs);
        System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
//        打开网址并下载文件
        driver.get("http://rj.baidu.com/soft/detail/35013.html?ald");
        driver.findElement(By.className("normal_download")).click();
    }

    @Test
    public void testFirefoxDown() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        设置火狐浏览器的默认下载文件，0表示桌面，1表示我的下载，2表示自定义文件夹
        firefoxProfile.setPreference("browser.download.folderList", "2");
//        设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir", "D:\\Tests");
//        设置无需确认下载的文件格式
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
//        打开一个预先配置的火狐
        WebDriver driver = new FirefoxDriver(firefoxProfile);
        driver.get("http://rj.baidu.com/soft/detail/35013.html?ald");
        driver.findElement(By.className("normal_download")).click();
    }
}

