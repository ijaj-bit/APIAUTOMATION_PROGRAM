package org.Ijaj.ex08_TestNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_All_BeforeTest {

    //PUT Request
    //1.getToken
    //2.getBookingId
    //3.test_PUT(which will use above 2 Methods)
    //4.closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("A");
    }


    @BeforeTest
    public void getBookingId(){
        System.out.println("B");
    }


    @Test
    public void test_PUT(){
        System.out.println("MAIN");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("CLOSE");
    }
}
