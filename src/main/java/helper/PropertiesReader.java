package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static String currentPath = System.getProperty("user.dir");

    public static Properties readFromFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(currentPath + filePath)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static String readPropertyFromFile(String filePath, String key) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(currentPath + filePath)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(key);
    }
}