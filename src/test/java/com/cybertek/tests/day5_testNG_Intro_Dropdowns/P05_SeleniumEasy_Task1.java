package com.cybertek.tests.day5_testNG_Intro_Dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));





    }

}
