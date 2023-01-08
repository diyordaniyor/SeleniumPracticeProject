package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ZeroBankVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement zeroText = driver.findElement(By.className("brand"));

        String expectedT = "Zero Bank";
        String actualT = zeroText.getText();

        if (actualT.equals(expectedT)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


        String expectedRef = "index.html";
        String actualHref = zeroText.getAttribute("href");

        System.out.println(expectedRef);
        System.out.println(actualHref);

        if (actualHref.contains(expectedRef)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }

}
