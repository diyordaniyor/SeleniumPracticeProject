package com.cybertek.tests.vytrack.fleep;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VehiclesPageTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void loginAsaStoreManager() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@class='title title-level-1' and contains( text( ) , 'Fleet') ] ")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(5000);

        WebElement subtitle = driver.findElement(By.className("oro-subtitle"));
        System.out.println(subtitle.getText());
        Assert.assertEquals(subtitle.getText(), "All Cars", "fail");

    }
    @Test
    public void loginAsaStoreManager2() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@class='title title-level-1' and contains( text( ) , 'Fleet') ] ")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//input[@value='1']"));

        String actualText = element.getText();
        String expected = "1";
        if (actualText==expected){
            System.out.println("Pass!");
        }else {
            System.out.println("Fail");
        }


    }




}
