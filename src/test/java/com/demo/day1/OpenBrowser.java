package com.demo.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class OpenBrowser {
    WebDriver driver;

    @Test
    public void openFireFoxBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void openFireFox2() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openIE() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\kola\\IdeaProjects\\Demo1\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
    }
