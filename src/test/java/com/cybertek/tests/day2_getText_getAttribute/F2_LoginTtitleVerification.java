package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_LoginTtitleVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("smth@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Me2213");

        String expectedT = "Log into Facebook | Facebook";

        Thread.sleep(7000);

        String actualT = driver.getTitle();

        System.out.println("expectedT = " + expectedT);
        System.out.println("actualT = " + actualT);
        if (actualT.equals(expectedT)){
            System.out.println("Verification Passed");
        }else {
            System.out.println("Fail!");
        }

    }

}
