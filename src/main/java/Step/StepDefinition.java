package Step;

import Page.BrowserNavigation;
import Page.PageInstantiation;
import Utilities.Utilities;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.rmi.CORBA.Util;
import java.util.List;

/*
    Author: RajithaMaru
 */

public class StepDefinition extends Utilities {

    static WebDriver driver;

    PageInstantiation page = PageFactory.initElements(driver, PageInstantiation.class);

    BrowserNavigation browserNavigation = PageFactory.initElements(driver, BrowserNavigation.class);

    String url = Utilities.getUrl();



    @BeforeTest
    @Given("^user launched the url$")
    public void userLaunchedTheUrl() throws Throwable {

        browserNavigation.startBrowser("chrome", url);

    }

    @AfterTest
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("failed");

            Utilities.screenshot(driver, "assessmentTestFail");
        }

        if (ITestResult.SUCCESS == result.getStatus()) {
            System.out.println("passed");

            Utilities.screenshot(driver, "assessmentTestPass");
        }

        driver.quit();
    }



    public Logger log = LoggerFactory.getLogger(StepDefinition.class);



    @When("^user enters the below values$")
    public void user_enters_the_below_values(DataTable values) throws Throwable {

       /* List<List<Double>> data = values.raw();

        float value1= (Float)data.get(1).get(1);
        float value2= data.get(2).get(1);
        float value3= data.get(3).get(1);
        float value4= data.get(4).get(1);
        float value5= data.get(5).get(1);*/


    }

    @Then("^the right count of values should appear on the screen$")
    public void the_right_count_of_values_should_appear_on_the_screen() throws Throwable {

        page.rightCountValuesOnScreen();

    }

    @Then("^all the values on the screen should be greater than zero$")
    public void all_the_values_on_the_screen_should_be_greater_than_zero() throws Throwable {

        page.valuesGreaterThanZero();

    }

    @Then("^the total balance should be correct$")
    public void the_total_balance_should_be_correct() throws Throwable {

    }

    @Then("^values should be formatted as currency$")
    public void values_should_be_formatted_as_currency() throws Throwable {

    }

    @Then("^total value amount should match sum of all the values$")
    public void total_value_amount_should_match_sum_of_all_the_values() throws Throwable {

        page.totalValueEqualIndsum();

    }


}
