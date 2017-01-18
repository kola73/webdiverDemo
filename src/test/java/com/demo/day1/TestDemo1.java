package com.demo.day1;

import org.testng.annotations.*;

/**
 * Created by kola on 2017/1/15.
 */

public class TestDemo1 {
    @Test
    public void test1() {
        System.out.println("这是 test");
    }

    @Test
    public void test4() {
        System.out.println("这是 test4");
    }

    @BeforeTest
    public void test2() {
        System.out.println("这是beforetest");
    }

    @BeforeMethod
    public void test3() {
        System.out.println("这是beforemethod");
    }

    @AfterMethod
    public void test5() {
        System.out.println("这是aftermethod");
    }

    @AfterTest
    public void test6() {
        System.out.println("这是aftertest");
    }
}
