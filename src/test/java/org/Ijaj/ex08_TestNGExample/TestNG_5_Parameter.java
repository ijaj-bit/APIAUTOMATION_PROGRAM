package org.Ijaj.ex08_TestNGExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_5_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value)
    {
        System.out.println("demo1");

        if (value.equalsIgnoreCase("chrome"))
        {
            System.out.println("start the chrome browser");
        }
        if (value.equalsIgnoreCase("firefox"))
        {
            System.out.println("start the firefox browser");
        }

    }


}
