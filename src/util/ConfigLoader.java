package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar application.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
