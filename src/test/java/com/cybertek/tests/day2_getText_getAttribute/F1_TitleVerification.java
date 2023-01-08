package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_TitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedT = "Facebook - log in or sign up";
        String actualT = driver.getTitle();
        System.out.println(expectedT);
        System.out.println(actualT);
        if (actualT.equals(expectedT)){
            System.out.println("Verification Passed");
        }else {
            System.out.println("Fail!");
        }


    }

}
