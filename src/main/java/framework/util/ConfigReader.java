package framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private static Properties prop;

    public static synchronized ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
            prop = new Properties();
            try {
                FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
                prop.load(ip);
            } catch (FileNotFoundException e) {
               throw new RuntimeException("config.properties not found under ./src/test/resources",e);
            } catch (IOException e) {
                throw new RuntimeException("Unable to read file config.properties",e);
            }
        }
        return instance;
    }


    private ConfigReader() {}

    public Properties readProperties(){
        return prop;
    }
}
