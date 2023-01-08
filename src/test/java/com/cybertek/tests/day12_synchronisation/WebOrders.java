package com.cybertek.tests.day12_synchronisation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

    }
    @Test
    public void checkBoxTest(){

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox: checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test
    public void updateZip(){
        String oldZipexpected = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[4]//td[9]")).getText();
        String oldZipActual = "21233";

        Assert.assertEquals(oldZipActual,oldZipexpected,"Fail");

        driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[4]//td[13]")).click();

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcode.clear();
        zipcode.sendKeys("20002");

        WebElement button = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        button.click();

        String newZipexpected = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[4]//td[9]")).getText();
        String newZipActual = "20002";

        Assert.assertEquals(newZipActual,newZipexpected,"Fail");
    }

}
