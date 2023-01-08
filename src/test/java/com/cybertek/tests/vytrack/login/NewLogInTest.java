package com.cybertek.tests.vytrack.login;

import com.cybertek.pages.LogInPage;
import com.cybertek.tests.vytrack.AbstractTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NewLogInTest extends AbstractTestBase {

    @Test
    public void verifyAgeTitle() throws InterruptedException {
        test=report.createTest("Verify Page Title");
        LogInPage logInPage= new LogInPage();
        logInPage.login();
        test.info("Log in as a store manager");
        Thread.sleep(2000);
        assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Test title was verified");
}

@Test
public void verifyWarningMessage(){
        test=report.createTest("Verify warning message");
        LogInPage logInPage = new LogInPage();
        logInPage.login("wrong","wrong");
        Assert.assertEquals(logInPage.getWarningMessageText(),"Invalid user name or password.");
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning mesage is displayed");
}



    @Test(dataProvider = "credentials")
    public void loginwithDDT(String userName , String password) throws InterruptedException {
        test=report.createTest("Verify Page Title");
        LogInPage logInPage= new LogInPage();
        logInPage.login(userName,password);
        test.info("Log in as a "+userName);
        Thread.sleep(3000);
        assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Test title was verified");
    }



@DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"storemanager110", "UserUser123"},
                {"user16", "UserUser123"}
        };
}
}
