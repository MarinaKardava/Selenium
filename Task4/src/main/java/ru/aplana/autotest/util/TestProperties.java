package ru.aplana.autotest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Maria on 07.09.2017.
 */
public class TestProperties {
    private final Properties properties = new Properties();

    private static ru.aplana.autotest.util.TestProperties INSTANCE = null;

    private TestProperties(){
        try {
            properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public static ru.aplana.autotest.util.TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new ru.aplana.autotest.util.TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
