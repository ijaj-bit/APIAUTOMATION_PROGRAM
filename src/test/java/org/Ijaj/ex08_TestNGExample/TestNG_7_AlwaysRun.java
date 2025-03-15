package org.Ijaj.ex08_TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_7_AlwaysRun {


    @Test()
    public void test1()
    {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test2()
    {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true,enabled = false)
    public void test3()
    {
        Assert.assertTrue(true);
    }
}
