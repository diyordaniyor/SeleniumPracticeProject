package com.cybertek.tests.day6_Dropdown_Review;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);
    }


    @Test
    public void task1_login_page_links_print_test(){



        List<WebElement> allLinks= driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks = " + allLinks.size());

        for (WebElement eachElement: allLinks){
            System.out.println("Each Link: "+eachElement.getText());

        }


    }

    @Test
    public void task2_order_placing_javaFaker(){

        WebElement oderLink = driver.findElement(By.xpath("//a[.='Order']"));
        oderLink.click();

        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInput.sendKeys(Keys.BACK_SPACE +"2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();
        nameInput.sendKeys(faker.name().firstName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode().replaceAll("-",""));

        WebElement visaRadio = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadio.click();

        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement expirationInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationInput.sendKeys("12/26");

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement successmessage = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(successmessage.isDisplayed(),"Fail");




    }

}
