package com.cybertek.pages;

import com.cybertek.utilities.COnfigurationReader;
import com.cybertek.utilities.Driver;
import com.fasterxml.jackson.core.JsonParser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement login;

    @FindBy(id="Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningmessage;

    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getWarningMessageText(){
        return warningmessage.getText();
    }

    public void login(String usernameValue , String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){
       username.sendKeys(COnfigurationReader.getProperty("store_manager"));
       password.sendKeys(COnfigurationReader.getProperty("password"),Keys.ENTER);
    }


}
