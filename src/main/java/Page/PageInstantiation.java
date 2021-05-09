package Page;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;


/*
    Author: RajithaMaru
 */
public class PageInstantiation {
    final static Logger log = LoggerFactory.getLogger(PageInstantiation.class);

    WebDriver driver;

    //constructor to initialize the driver
    public PageInstantiation(WebDriver ldriver) {
        this.driver = ldriver;
    }

    //declaring all the webelement with the id property

    @FindBy(id = "lbl_val_1")
    WebElement input1;
    @FindBy(id = "lbl_val_2")
    WebElement input2;
    @FindBy(id = "lbl_val_3")
    WebElement input3;
    @FindBy(id = "lbl_val_4")
    WebElement input4;
    @FindBy(id = "lbl_val_5")
    WebElement input5;
    @FindBy(id = "lbl_ttl_val")
    WebElement totalVal;

    @FindBy(id = "txt_val_1")
    WebElement txtVal1;

    @FindBy(id = "txt_val_2")
    WebElement txtVal2;

    @FindBy(id = "txt_val_3")
    WebElement txtVal3;

    @FindBy(id = "txt_val_4")
    WebElement txtVal4;

    @FindBy(id = "txt_val_5")
    WebElement txtVal5;

    @FindBy(id = "txt_ttl_val")
    WebElement totalTxtVal;

    @FindBy(xpath = ".//[contains(id,txt_val)]")
    List<WebElement> values;

    @FindBy(xpath = ".//[contains(id,lbl_val)]")
    List<WebElement> inputvalues;

    /*
     this is method will check whether the right count of values are displaying on the screen
     */
    public void rightCountValuesOnScreen()

    {
        if (values.size() == 5) {
            Assert.assertEquals(values.size() == 5, false);
            System.out.println(" the right count of values are displayed on the screen");


        }
    }
    /*
        this method will check whether values displayed on the screen are greather than zero
     */

    public void valuesGreaterThanZero() {


        for (int i = 0; i < values.size(); i++) {
            WebElement ele = values.get(i);

            String S = ele.getText();

            String newStr = S.replaceAll("[$,]", "");

            Double a = Double.parseDouble(newStr);

            Assert.assertEquals(a > 0, false);


        }
    }


    /*
    this method will display the values dynamically based on the screen
     */
    public void totalBlcOnTheScreen() {

        double individualSum = 0.0f;

        String totalInputSum = txtVal1.getText();

        double totalDoubleSum = Double.parseDouble(totalInputSum);

        for (int i = 0; i < inputvalues.size(); i++) {
            WebElement ele = inputvalues.get(i);

            String S = ele.getText();

            String newStr = S.replaceAll("[$,]", "");

            Double a = Double.parseDouble(newStr);
            individualSum = individualSum + a;

        }

        Assert.assertEquals(totalDoubleSum, individualSum);


    }


    /*
        this method will check whether the values are displayed in currency format(in this case $)
     */

    public void currencyFormat() {

        Currency currency = Currency.getInstance(Locale.US);
        String symbol = currency.getSymbol();

        for (WebElement ele : values) {
            String string = ele.getText();

            if (string.startsWith(symbol) || string.endsWith(symbol)) {
                System.out.println("curreny format is valid");
            } else {
                System.out.println("curreny format is invalid");
            }

        }
    }

    /*
        this method will check whether the individual values are equal to total sum
     */
    public void totalValueEqualIndsum() {

        double individualSum = 0.0f;

        String totalSum = totalTxtVal.getText();

        double totalsum = Double.parseDouble(totalSum);

        for (int i = 0; i < values.size(); i++) {
            WebElement ele = values.get(i);

            String S = ele.getText();

            String newStr = S.replaceAll("[$,]", "");

            Double a = Double.parseDouble(newStr);
            individualSum = individualSum + a;

        }

        Assert.assertEquals(totalSum, individualSum);

    }
}



