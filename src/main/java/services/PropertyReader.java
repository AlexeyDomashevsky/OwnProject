package services;

import java.util.ResourceBundle;

public class PropertyReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("propFile"));

    private PropertyReader() {
    }

    public static String getProperty(String propertyName) {
        return resourceBundle.getString(propertyName);
    }
}
