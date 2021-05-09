package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
    Author: RajithaMaru
 */
public class BrowserNavigation {


     WebDriver driver;

    public WebDriver startBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "c://maru//testdata//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "c://maru//testdata//iedriver.exe");
        }

        driver.manage().window().maximize();
        driver.get(url);


        return driver;
    }
}
