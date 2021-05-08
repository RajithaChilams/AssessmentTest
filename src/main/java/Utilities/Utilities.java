package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
    static String url;

    public static String getUrl() {



        File f = new File("C:\\CucumberProjects\\privateRepo\\AssessmentTest\\config.properties");
        try {
            FileInputStream reader = new FileInputStream(f);
            Properties p = new Properties();
            p.load(reader);
            url = p.getProperty("url");


        } catch (Exception e) {
            e.printStackTrace();
        }


        return url;
    }


    public static void screenshot(WebDriver driver, String name) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("C://maru//testresults//"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
