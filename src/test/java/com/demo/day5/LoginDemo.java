package com.demo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by kola on 2017/1/8.
 * 封装
 */
public class LoginDemo {
    public static void login(WebDriver driver, String email, String password) {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
    }
}
