package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_cssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);


    }

}
