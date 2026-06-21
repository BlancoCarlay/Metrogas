package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("No se encontró el archivo config.properties en /src/test/resources");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando config.properties: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
