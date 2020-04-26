package com.tests;

import org.testng.annotations.Test;

public class TestNGPriority {

    @Test (dependsOnMethods = "b",priority = 0)
    public void a()
    {
        System.out.println("A");
    }
    @Test (dependsOnMethods = "a",priority = 1)
    public void b()
    {
        System.out.println("B");
    }

}
