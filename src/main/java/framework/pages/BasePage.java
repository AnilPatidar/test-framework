package framework.pages;

import framework.util.ConfigReader;
import framework.util.ScrollToElementUtil;
import framework.util.WaitUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BasePage {

    protected Properties properties;
    protected WaitUtils waitUtils;
    protected ScrollToElementUtil scrollUtil;
    protected WebDriver driver;

    public BasePage(WebDriver driverObj){
        properties= ConfigReader.getInstance().readProperties();
        driver=driverObj;
        waitUtils= new WaitUtils(driver);
        scrollUtil = new ScrollToElementUtil(driver,10);

    }

}
