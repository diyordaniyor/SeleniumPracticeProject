package com.cybertek.tests.day12_synchronisation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait <WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);


        WebElement submitBtn = wait.until(webDriver -> driver.findElement(By.xpath("//button[text()='Submit']")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        submitBtn.click();


        }
    }
