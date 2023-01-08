package com.cybertek.tests.day11_Executor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");

    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return document.title");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void clickText() throws InterruptedException {
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");
    }

    @Test
    public void textInputTest() throws InterruptedException {
        driver.findElement(By.linkText("Form Authentication")).click();
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginButton);

        Thread.sleep(6000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader, expected);


    }

    @Test
    public void scrollToElement() throws InterruptedException {
        WebElement link = driver.findElement(By.linkText("CYDEO"));
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", link);

    }

    @Test
    public void scrollToTest() throws InterruptedException {
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i =0 ;i<15;i++){
            js.executeScript("window.scrollBy(0, 1000)");
            Thread.sleep(1000);
        }
    }

    /*@AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

     */





}
