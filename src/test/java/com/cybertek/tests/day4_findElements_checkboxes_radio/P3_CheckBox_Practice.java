package com.cybertek.tests.day4_findElements_checkboxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_CheckBox_Practice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is not selected");
        }else {
            System.out.println("Checkbox 1 is selected");
        }

        if (!checkbox2.isSelected()){
            System.out.println("Checkbox 2 is not selected");
        }else {
            System.out.println("Checkbox 2 is selected");
        }


        Thread.sleep(1000);
        checkbox1.click();

        Thread.sleep(1000);
        checkbox2.click();

        if (!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is not selected");
        }else {
            System.out.println("Checkbox 1 is selected");
        }

        if (!checkbox2.isSelected()){
            System.out.println("Checkbox 2 is not selected");
        }else {
            System.out.println("Checkbox 2 is selected");
        }

        WebElement homelink = driver.findElement(By.xpath("//a[.='Home']"));

        homelink.click();

        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);
        checkbox1 = driver.findElement(By.xpath("//input[@value='male']"));
        checkbox1.click();


    }

}
