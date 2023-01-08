package com.cybertek.tests.day11_Executor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void scrollText() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        Thread.sleep(3000);

    }

    @Test
    public void scrollElements() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);
        WebElement  link = driver.findElement(By.linkText("CYDEO"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", link);

    }

}
