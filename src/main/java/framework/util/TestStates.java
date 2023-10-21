package framework.util;

import framework.model.BrowserType;

import java.util.HashMap;
import java.util.Map;

public class TestStates {
    private static ThreadLocal<Map<String, Object>> states = ThreadLocal.withInitial(HashMap::new);

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

    public static Map<String, Object> getTestData() {
        return states.get();
    }

}
