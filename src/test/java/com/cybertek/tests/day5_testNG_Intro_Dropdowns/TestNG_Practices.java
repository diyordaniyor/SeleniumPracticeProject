package com.cybertek.tests.day5_testNG_Intro_Dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void google_title_verification(){
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Title are not matching");
        System.out.println("A");
    }

    @Test
    public void google_search_title_verification(){
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("apple"+ Keys.ENTER);

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title does not contain");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
