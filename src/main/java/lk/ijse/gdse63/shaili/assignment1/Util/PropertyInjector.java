package lk.ijse.gdse63.shaili.assignment1.Util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertyInjector {

    public static Properties injectProperties() {
        Properties properties = new Properties();
        URL resource = PropertyInjector.class.getResource("/hibernate.properties");
        try {
            //Reading of the property file.
            properties.load(resource.openStream());
            return properties;
        } catch (IOException e) {
            System.out.println("An error occurred while loading the properties file. : " + e.getLocalizedMessage());
        }
        throw new RuntimeException("Properties file not found.");

    }
}
