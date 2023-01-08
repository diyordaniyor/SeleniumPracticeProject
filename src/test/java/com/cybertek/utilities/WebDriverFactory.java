package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else {
            System.out.println("Browser did not exist. Driver = null!");
            return null;
        }

    }

    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for (WebElement element: elements){
            textValues.add(element.getText());
        }
        return textValues;
    }




}
