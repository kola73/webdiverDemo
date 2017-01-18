package com.demo.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kola on 2017/1/15.
 */
public class AssertTest {
    @Test
    public void assertDemo1() {
        String a = "1234";
        String b = "1234";
        Assert.assertEquals(a, b);
    }

    @Test
    public void assertDemo2() {
        int a = 2;
        int b = 3;
        Assert.assertNotEquals(a, b, "a等于b");
    }

    @Test
    public void assertDemo3() {
        String a = "";
        Assert.assertNotNull(a, "a不为空");
    }

    @Test
    public void assertDemo4() {
        String a = null;
        Assert.assertNull(a, "a为空");
    }

    @Test
    public void assertDemo5() {
        boolean a = false;
        String b = "dds";
        Assert.assertFalse(a);
        Assert.assertNotNull(b, "不为空");
    }
}

