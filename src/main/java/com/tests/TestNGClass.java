package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass
{

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("beforeTest in "+ TestNGClass.class.getName());
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("BeforeMethodIn "+ TestNGClass.class.getName());
    }
    @Test(groups = "TestSuite01")
    public void getBeforeMethod()
    {
        System.out.println("Inside Test in"+ TestNGClass.class.getName());
    }

    @Test
    public void getBeforeMethod2()
    {
        System.out.println("Inside Test in"+ TestNGClass.class.getName());
    }

    @BeforeTest
    public void beforeTest1()
    {
        System.out.println("beforeTest2 in "+ TestNGClass.class.getName());
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("beforeClass in "+ TestNGClass.class.getName());
    }
}