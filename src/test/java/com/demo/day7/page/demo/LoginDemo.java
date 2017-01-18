package com.demo.day7.page.demo;

import day7.po.loginPODemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.security.auth.login.LoginContext;

/**
 * Created by kola on 2017/1/8.
 * 封装
 */
public class LoginDemo {
    public static void login(WebDriver driver, String email, String password) {
        WebElement frame = driver.findElement(loginPODemo.iframe);
        driver.switchTo().frame(frame);
        driver.findElement(loginPODemo.mailTextField).sendKeys(email);
        driver.findElement(loginPODemo.pwdTextField).sendKeys(password);
        driver.findElement(loginPODemo.loginButton).click();
    }
}
