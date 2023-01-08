package com.cybertek.tests.day4_findElements_checkboxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_MerriamWebster_Links {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linkWithText = 0;
        int linkWithoutText = 0;
        
        for (WebElement eachLink: listOfLinks){
            String textOfEachlink=eachLink.getText();
            System.out.println(eachLink.getText());

            if (textOfEachlink.isEmpty()){
                linkWithoutText++;
            }else {
                linkWithText++;
            }
        }
        System.out.println("linkWithoutText = " + linkWithoutText);
        System.out.println("linkWithText = " + linkWithText);
        System.out.println("listOfLinks = " + listOfLinks.size());


            }
        }




