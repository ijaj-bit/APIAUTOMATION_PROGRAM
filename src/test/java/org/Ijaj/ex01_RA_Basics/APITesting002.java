package org.Ijaj.ex01_RA_Basics;

public class APITesting002 {
    //THIS IS NOTHING BUT NON-CHAINING PATTERN(MORE REAPEATED CODE NO REUSABILITY)
    public static void main(String[] args) {
        APITesting002 np =new APITesting002();
        np.step1();
        np.step2();
        np.step3("IJAJ");
    }

    //NoDesignPattern
    public void step1()
    {
        System.out.println("step1");
    }
    public void step2()
    {
        System.out.println("step2");
    }
    public void step3(String param)
    {
        System.out.println("step3");
    }
}
