package com.cybertek.tests.vytrack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.COnfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        System.out.println("Report Name : "+reportName);
        reportName = reportName==null?"report.html":reportName+".html";
        report = new ExtentReports();
        String reportPath = "";
        if (System.getProperty("os.name").toLowerCase().contains("win")){
            reportPath = System.getProperty("user.dir")+"\\test-output\\"+reportName;
        }else {
            reportPath = System.getProperty("user.dir")+"/test-output/"+reportName;
        }
        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");

    }

    @AfterTest
    public void teardownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setup(){
        String URL = COnfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait= new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException, InterruptedException {
        if (iTestResult.getStatus()==ITestResult.FAILURE){
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            Thread.sleep(2000);
            test.fail(iTestResult.getName());
            Thread.sleep(2000);
            test.addScreenCaptureFromPath(screenshotPath,"Failed");

            test.fail(iTestResult.getThrowable());

        }
        Thread.sleep(1000);
        Driver.closeDriver();
    }





}
