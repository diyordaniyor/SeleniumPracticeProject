package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");


        String expectedH = "Facebook helps you connect and share with the people in your life.";

        String actualH = driver.findElement(By.className("_8eso")).getText();
        System.out.println(actualH);

        if (actualH.equals(expectedH)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }



    }

}
