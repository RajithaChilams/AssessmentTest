package Page;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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




    public static void rightValuesOnScreen ()

    {

    }

    public static void valuesGreaterThanZero()
    {

    }

    public static void totalBlc()
    {


    }

    public static void currencyFormat()
    {

    }

    public static void totalValueEqualIndsum()
    {

    }

}
