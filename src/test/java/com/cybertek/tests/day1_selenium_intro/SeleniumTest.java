package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        System.out.println("The title of the page is: "+driver.getTitle());
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL is "+actualURL);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to("https://www.apple.com");


        String pageSource = driver.getPageSource();
        System.out.println("Page source: "+pageSource);
        driver.close();
    }

}
