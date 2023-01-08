package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WT_CybertekVerification {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

        driver.findElement(By.id("identify_email")).sendKeys("anyemail@domain.com");

        driver.findElement(By.id("did_submit")).click();

        String expectedURL = "email_sent";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("URL Pass");
        }else {
            System.out.println("URL Fail");
        }

        String actualText = driver.findElement(By.name("confirmation_message")).getText();
        String expectedText = "Email been sent";



    }

}
