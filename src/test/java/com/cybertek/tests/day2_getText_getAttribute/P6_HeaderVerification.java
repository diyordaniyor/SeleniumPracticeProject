package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_HeaderVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String str = driver.findElement(By.tagName("h3")).getText();
        String expected = "Log in to ZeroBank";

        System.out.println(str);

        if (str.equals(expected)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }



    }

}
