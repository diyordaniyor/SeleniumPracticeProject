package com.cybertek.tests.day13_Properties;

import com.cybertek.utilities.COnfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = COnfigurationReader.getProperty("browser");
        String url = COnfigurationReader.getProperty("qa1");
        System.out.println(browser);
        System.out.println(url);
    }

}
