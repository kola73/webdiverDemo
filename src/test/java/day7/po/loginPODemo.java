package day7.po;

import org.openqa.selenium.By;

/**
 * Created by kola on 2017/1/17.
 * 用了这个以后后续如果需要调用，直接用“对象名.方法”名即可实现调用。
 * 如果页面过于复杂，可以拆分成多块page
 * 创建后的调用方式：WebElement element = driver.findElemnt(对象名.方法名)
 */
public class loginPODemo {
//    定位地址框
    public static By mailTextField = By.name("email");
//    定位密码框
    public static By pwdTextField = By.name("password");
//    定位登录框
    public static By loginButton = By.id("dologin");
//    iframe定位方式
    public static By iframe = By.id("x-URS-iframe");
}
