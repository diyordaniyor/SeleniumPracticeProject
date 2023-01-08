package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String expectedT = "Google";
        String actualT = driver.getTitle();
        if (actualT.equals(expectedT)){
            System.out.println("Verification Passed");
        }else {
            System.out.println("Fail!");
        }

    }
}
