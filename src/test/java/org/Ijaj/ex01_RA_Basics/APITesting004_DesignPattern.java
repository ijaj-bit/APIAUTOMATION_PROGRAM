package org.Ijaj.ex01_RA_Basics;

public class APITesting004_DesignPattern {
    // THIS IS NOTHING BUT CHAINING PATTERN
    public static void main(String[] args) {
        APITesting004_DesignPattern bp = new APITesting004_DesignPattern();
        bp.step1().step2().step3("IJAJ");
    }


    //IT FOLLOWS THE BUILDERPATTERN
    public APITesting004_DesignPattern step1()
    {
        System.out.println("step1");
        return  this;
    }
    public APITesting004_DesignPattern step2()
    {
        System.out.println("step2");
        return  this;
    }
    public APITesting004_DesignPattern step3(String param)
    {
        System.out.println("step3->"+param);
        return  this;
    }



}
