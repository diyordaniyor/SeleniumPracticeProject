package com.cybertek.tests.vytrack.login;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void invalidUsername() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("invalidusername");
        driver.findElement(By.id("prependedInput2")).sendKeys("USerUser123", Keys.ENTER);
        Thread.sleep(3000);
        WebElement warningElement = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(warningElement.isDisplayed());
    }

    @Test
    public void loginAsaStoreManager() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver , 15);
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText("Dashboard")));

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Fail!");
    }




    /* @AfterMethod
    public void teardown(){
        driver.quit();
    }

     */


}
