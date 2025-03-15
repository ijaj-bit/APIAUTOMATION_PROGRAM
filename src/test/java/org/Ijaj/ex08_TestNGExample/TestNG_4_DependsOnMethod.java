package org.Ijaj.ex08_TestNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_4_DependsOnMethod {

    @Test
    public void serverStartedof()
    {
        System.out.println("I will run First");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedof")
    public void method1()
    {
        System.out.println("1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedof")
    public void method2()
    {
        System.out.println("2");
        Assert.assertTrue(true);
    }

}
