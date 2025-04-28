package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties = new Properties();

    public PropertiesReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        properties.load(fis);
    }

    public String get(String key) {
        return properties.getProperty(key);

    }
}