package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.nio.channels.AcceptPendingException;

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,20);

    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;

    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String tabName , String moduleName) throws InterruptedException {
        String tabNamexpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleNamexpath = "//span[@class='title title-level-2' and text()='"+moduleName+"']";

        WebElement tabElement = driver.findElement(By.xpath(tabNamexpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleNamexpath));

        Actions actions= new Actions(driver);
        Thread.sleep(8000);

        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();

        Thread.sleep(2000);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

}
