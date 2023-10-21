package framework.pages;

import framework.util.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

public class BasePage {

    protected Properties properties;

    public BasePage(){
        properties= ConfigReader.getInstance().readProperties();
    }

}
