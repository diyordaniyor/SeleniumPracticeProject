package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_AttributeVerification {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedA = "registration_form";

        String actualA = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        System.out.println("expectedA = " + expectedA);
        System.out.println("actualA = " + actualA);

        if (actualA.contains(expectedA)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }

}
