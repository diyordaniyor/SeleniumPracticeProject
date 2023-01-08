package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        String expectedURL = "facebook";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedURL)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }
}
