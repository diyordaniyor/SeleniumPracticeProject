package com.cybertek.tests.day12_synchronisation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }


}
