package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationsAndTitleVerification {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.findElement(By.linkText("Gmail")).click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.navigate().back();

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.contains(expectedGoogleTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }

}
