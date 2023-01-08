package com.cybertek.tests.vytrack.actvities;

import com.cybertek.pages.LogInPage;
import com.cybertek.pages.activities.CalendarEventsPage;
import com.cybertek.tests.vytrack.AbstractTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {

    LogInPage logInPage = new LogInPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


    @Test
    public void defaultOptionsTest() throws InterruptedException {
        LogInPage logInPage = new LogInPage(); // creating new object to interact with LoginPage (we created earlier)
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify default login options");
        logInPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM d, yyyy");
        Assert.assertEquals(actualStartDate,expectedStartDate);
        test.pass("Default options verified");


    }

    /**
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/

    @Test
    public void timeDifferenceTest() throws InterruptedException {

        LogInPage loginPage = new LogInPage(); // creating new object to interact with LoginPage (we created earlier)
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        test = report.createTest("Verify time difference");

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        BrowserUtils.wait(2);
        String startTime = calendarEventsPage.getStartTime(); //get start time
        String endTime = calendarEventsPage.getEndTime(); //get end time

        String format = "h:mm a"; //format : 5:15 AM for example

        long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format );
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual, 1 , "Time difference is not correct");

        test.pass("Time difference verified");

    }
    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */

    @Test (description = "verify that column displays: Title/Calendar/Start/End/Recurrent/Recurrence/Invitation Status")
    public void columnNamesTest() throws InterruptedException {

        LogInPage loginPage = new LogInPage(); // creating new object to interact with LoginPage (we created earlier)
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        test = report.createTest("Verify column names");

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        // System.out.println(calendarEventsPage.getColumnNames() );
        List<String > expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
        test.pass("Column names verified");

    }


    //PERFECT TEST :
    //NO WebElements in the test
    //NO Waits in the test! go inside the method itself on the page class and add there

    //ONLY ASSERTIONS are present!!


    //this is POM in action :
    // nobody access webElemnets at all - we encapluated it
    //we can see only methods and moreover
    //in our test there is no Waits! no switching between frames
    //clean test code
    @Test (dataProvider = "calendarEvents") //this is MANDATORY!
    public void createCalendarEventTest(String title, String description) throws InterruptedException {
        //NoSuchSessionException: happens when you run couple tests inside one test
        //if you have more one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test
        LogInPage loginPage = new LogInPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        test = report.createTest("Create calendar event for" + title);
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();
        //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);
        test.pass("Calendar event was created successfully!");
    }




    @DataProvider (name = "calendarEvents") //this name is optional!! NO NEED
    public Object[][] calendarEvents(){
        return new Object[][] {
                {"Daily stand-up", "Scrum meeting to provide updates"},
                {"Sprint Review", "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}
        } ;
    }




    //@Test
    //public void verifyCurrentUserName(){
    //    loginPage.login();
    //    calendarEventsPage.navigateTo("Activities","Calendar Events");
    //    calendarEventsPage.clickCreateCalanderEvent();
    //    Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());
    //}

}



