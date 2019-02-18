package services;

import java.util.ResourceBundle;

public class PropertyReader {

    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public PropertyReader() {
    }

    public static String getProperty(String propertyName){
        return resourceBundle.getString(propertyName);
    }
}
