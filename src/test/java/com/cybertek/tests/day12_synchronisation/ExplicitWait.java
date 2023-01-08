package com.cybertek.tests.day12_synchronisation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs("Google"));


        driver.navigate().to("http://www.amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));
    }

    @Test
    public void waitForVisability(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");

        wait.until(ExpectedConditions.visibilityOf(submitButton));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();


    }

    @Test
    public void elementToBeClickable() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitButton.click();

    }

}
