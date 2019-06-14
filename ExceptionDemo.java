package com.company;

import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args)
    {
        Test t=new Test();
        try
        {
            t.abc();
        }
        catch (Exception e)
        {

        }
    }
}

class Test extends Test2
{
    public void abc()throws ArithmeticException
    {
        System.out.println("child class");
    }
}

class Test2
{
    public void abc() throws Exception
    {
        System.out.println("base class.");
    }
}