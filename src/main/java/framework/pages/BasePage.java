package framework.pages;

import framework.util.ConfigReader;
import java.util.Properties;

public class BasePage {

    protected Properties properties;

    public BasePage(){
        properties= ConfigReader.getInstance().readProperties();
    }

}
