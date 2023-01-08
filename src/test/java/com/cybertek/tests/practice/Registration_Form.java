package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration_Form {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement firstnameInput = driver.findElement(By.name("firstname"));
        WebElement seconfnameInput = driver.findElement(By.name("lastname"));
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement phoneInput = driver.findElement(By.name("phone"));
        WebElement dateOfBirth = driver.findElement(By.name("birthday"));

        Faker faker = new Faker();
        firstnameInput.sendKeys(faker.name().firstName());
        seconfnameInput.sendKeys(faker.name().lastName());
        usernameInput.sendKeys("blablaboev");
        emailInput.sendKeys("blabla@gmail.com");
        passwordInput.sendKeys("blablabla");
        phoneInput.sendKeys("303-333-3333");
        dateOfBirth.sendKeys("04/16/2001");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='male']"));
        checkbox1.click();

        Select officeselection = new Select(driver.findElement(By.name("department")));
        officeselection.selectByVisibleText("Department of Engineering");

        Select jobTitlle = new Select(driver.findElement(By.name("job_title")));
        jobTitlle.selectByVisibleText("SDET");

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='java']"));
        checkbox2.click();

        WebElement signUpButtton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButtton.click();

        Thread.sleep(8000);
        String actualText = driver.getTitle();
        String expected = "Registration Confirmation";
        Assert.assertEquals(actualText,expected,"Fail");


    }


    /*@AfterMethod
    public void teardown(){
        driver.quit();
    }

     */



}
