package com.cybertek.tests.vytrack.fleep;

import com.cybertek.pages.LogInPage;
import com.cybertek.pages.fleet.VehiclesPage;
import com.cybertek.tests.vytrack.AbstractTestBase;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class NewVehiclePageTests extends AbstractTestBase {

    @Test
    public void verifyTitle() throws InterruptedException {
        LogInPage logInPage= new LogInPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        logInPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);



    }



}
