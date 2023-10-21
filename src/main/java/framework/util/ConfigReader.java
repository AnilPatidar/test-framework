package framework.util;

import framework.model.BrowserType;

public class ConfigReader {
    private static BrowserType browserType = null;
    public static void setBrowserType(BrowserType browser){
        browserType= browser;
    }

    public static BrowserType getBrowserType(){

        if(browserType != null){
            return browserType;
        }else{
            throw new RuntimeException("please specify the browser in the testng xml file");
        }
    }

}
