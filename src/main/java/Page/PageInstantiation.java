package Page;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.util.List;


/*
    Author: RajithaMaru
 */
public class PageInstantiation {
    final static Logger log = LoggerFactory.getLogger(PageInstantiation.class);

    static WebDriver driver;

    public PageInstantiation(WebDriver ldriver) {
        this.driver = ldriver;
    }

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


    /*
     this is method will check whether the right values are displaying on the screen
     */
    public void rightCountValuesOnScreen()

    {


        List<WebElement> values = driver.findElements(By.xpath(".//[contains(id,txt_val)]"));

        if (values.size() == 5) {
            System.out.println(" the right count of values are displayed on the screen");
        } else {
            System.out.println("the values are missing");
        }

    }

    /*
        this method will check whether values displayed on the screen are greather than zero
     */

    public void valuesGreaterThanZero() {

        List<WebElement> valuesGrtZero = driver.findElements(By.xpath(".//[contains(id,txt_val)]"));

        for (int i = 0; i < valuesGrtZero.size(); i++) {
            WebElement ele = valuesGrtZero.get(i);

            String S = ele.getText();

            String newStr = S.replaceAll("[$,]", "");

            Float a = Float.parseFloat(newStr);

            if (a > 0) {
                System.out.println("values displayed on the screen are greater than zero");
            } else {
                System.out.println("values are less than zero");
            }


        }
    }


    public void totalBlc() {


    }

    /*
        this method will check whether the values are displayed in currency format(in this case $)
     */

    public void currencyFormat() {



    }

    /*
        this method will check whether the individual values are equal to total sum
     */
    public void totalValueEqualIndsum() {

        float indivualSum = 0.0f;
        List<WebElement> valuesGrtZero = driver.findElements(By.xpath(".//[contains(id,txt_val)]"));

        String totalSum = totalTxtVal.getText();

        float totalsum = Float.parseFloat(totalSum);

        for (int i = 0; i < valuesGrtZero.size(); i++) {
            WebElement ele = valuesGrtZero.get(i);

            String S = ele.getText();

            String newStr = S.replaceAll("[$,]", "");

            Float a = Float.parseFloat(newStr);
            indivualSum = indivualSum + a;

        }

        if (totalsum == indivualSum) {
            System.out.println("indiviual sums are matching with total sum");
        } else {
            System.out.println("individuals sums are not matching with total sum");
        }


    }

}
