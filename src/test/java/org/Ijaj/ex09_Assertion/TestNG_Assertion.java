package org.Ijaj.ex09_Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertion {

    //Hard Assertion

    @Test
    public void test_hardassertExample()
    {
        System.out.println("start of the program");
        boolean is_neeru_male=false;

        Assert.assertEquals("Ijaj","ijaj");
        System.out.println("end of the program");
    }

    //Soft Assertion
    @Test
    public void test_softassertExample()
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("end of the program");
        softAssert.assertAll();
    }
}
