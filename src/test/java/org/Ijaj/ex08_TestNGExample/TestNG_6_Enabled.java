package org.Ijaj.ex08_TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_6_Enabled {


    @Test(enabled = true)
    public void test1()
    {
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test2()
    {
        Assert.assertTrue(true);
    }

    @Test(enabled = true)
    public void test3()
    {
        Assert.assertTrue(true);
    }
}
