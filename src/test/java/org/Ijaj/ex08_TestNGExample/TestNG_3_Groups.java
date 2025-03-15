package org.Ijaj.ex08_TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

//sanity-1
//regression-3
//p1=2

public class TestNG_3_Groups {

    @Test(groups = {"sanity","reg"},priority = 1)
    public void test_SanityRun()
    {
        System.out.println("SANITY");
        System.out.println("QA");
        Assert.assertTrue(true);
    }


    @Test(groups ={"p1","reg"},priority = 2)
    public void test_RegRun()
    {
        System.out.println("Regression");
        System.out.println("QA");
        Assert.assertTrue(false);
    }

    @Test(groups = {"p1","reg"},priority = -1)
    public void test_SmokeRun()
    {
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(false);
    }
}
