package com.cybertek.tests.day12_synchronisation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @Test
    public void sortAlphabetOrder() throws InterruptedException {
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        Thread.sleep(3000);
        List<WebElement> column =driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i =0;i<=column.size()-1;i++){
            String value = column.get(i).getText();
            String nextValue = column.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue)<0);
        }

    }


}
