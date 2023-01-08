package com.cybertek.tests.day4_findElements_checkboxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P0_FindElements_Practice1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> listOfLinks= driver.findElements(By.xpath("//body//a"));

        for (WebElement eachLink : listOfLinks){
            System.out.println(eachLink.getText());
        }

        int number =  listOfLinks.size();

        System.out.println("number = " + number);



    }
}
