package com.cybertek.tests.day5_testNG_Intro_Dropdowns;


import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Introduction {

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After class is running");
    }


    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMwthod(){
        System.out.println("After method is running");
    }



    @Test
    public void test1(){
        System.out.println("Test1 is running");

    }

    @Test
    public void test2(){
        System.out.println("Test2 is running");
    }

    @Test

    public void test3(){
        String str1 = "TestNG";
        String str2 = "TestNG";
        String str3 = "awsdsfdf";
        Assert.assertTrue(str1.equals(str2));
        Assert.assertTrue(str1.equals(str3));

        System.out.println("Just for check");

        Assert.assertEquals(str1,str2,"Failure message");
    }

}
