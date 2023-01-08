package com.cybertek.tests.day11_Executor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        Thread.sleep(3000);
    }

    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for (WebElement eachElement: columnNames){
            System.out.println(eachElement.getText());
        }
        Assert.assertEquals(WebDriverFactory.getTextFromWebElements(columnNames),expected);

    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),4);
    }

    @Test
    public void getSpecificColumn(){
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(WebDriverFactory.getTextFromWebElements(links));
    }

    @Test
    public void deleteRowTest() throws InterruptedException {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(3000);

        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount,3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }

    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i =0;i<columnNames.size();i++){
            if (columnNames.get(i).getText().equals(columnName)){
                index=i+1;
            }
        }
        Assert.assertEquals(index,3);
    }

    @Test
    public void getSpecificCell(){
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),expected);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }


}
