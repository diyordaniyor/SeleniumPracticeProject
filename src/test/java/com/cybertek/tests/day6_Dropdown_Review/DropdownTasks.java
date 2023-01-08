package com.cybertek.tests.day6_Dropdown_Review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @BeforeMethod
    public void setupMethod(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException {
        Select selection = new Select(driver.findElement(By.id("state")));
        Thread.sleep(2000);
        selection.selectByVisibleText("Illinois");
        Thread.sleep(2000);
        selection.selectByValue("VA");
        Thread.sleep(2000);
        selection.selectByIndex(5);

        String actual = selection.getFirstSelectedOption().getText();
        String expected = "California";

        Assert.assertEquals(actual,expected,"Fail");



    }

    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Thread.sleep(2000);
        yearDropdown.selectByVisibleText("1923");
        Thread.sleep(2000);
        monthDropdown.selectByValue("11");
        Thread.sleep(2000);
        dayDropdown.selectByIndex(0);

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = "1923";
        String actualMonth = "December";
        String actualDay = "1";

        Assert.assertEquals(actualYear,expectedYear,"Fail Year");
        Assert.assertEquals(actualMonth,expectedMonth,"Fail Month");
        Assert.assertEquals(actualDay,expectedDay,"Fail Day");



    }

    @Test
    public void test4_multiple_value_select_dropdown() throws InterruptedException{
        Select selectAll = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> allOptions = selectAll.getOptions();

        for (WebElement eachOption: allOptions){
            Thread.sleep(500);
            eachOption.click();
            System.out.println("Selected: "+eachOption.getText());

            Assert.assertTrue(eachOption.isSelected(),"The option: "+eachOption.getText()+" is not selected");
        }

        selectAll.deselectAll();

        for (WebElement eachOption: allOptions){
            Assert.assertFalse(eachOption.isSelected());
        }



    }

    @Test
    public void test5_html_dropdown_handling(){
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));

        websiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookLink.click();

        String actualtitle = driver.getTitle();
        String expectitle = "Facebook – log in or sign up";

        Assert.assertEquals(actualtitle,expectitle,"Fail");



    }






}
