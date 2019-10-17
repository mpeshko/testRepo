package framework.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Property resource manager class
 */
public class PropertiesResourceManager {

    private static final String EXTENSION = ".properties";
    private static final String RESOURCE_NOT_FOUND_MESSAGE = "Resource %s not found";
    private static final String CANT_READ_PROPERTIES_MESSAGE = "Can't read properties from %s";
    private Properties properties = new Properties();

    /**
     * Property resource manager constructor
     *
     * @param resourceName Resource name to create properties
     */
    public PropertiesResourceManager(String resourceName) {
        String resourceNameWithExtension = resourceName + EXTENSION;
        InputStream propertiesStream = this.getClass().getClassLoader().getResourceAsStream(resourceNameWithExtension);
        if (propertiesStream != null) {
            try {
                properties.load(propertiesStream);
                propertiesStream.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * Get property by key
     *
     * @param key Property key
     * @return Found property value
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get property by key and default value
     *
     * @param key          Property key
     * @param defaultValue Property default value
     * @return Found property value
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Get system property by key
     *
     * @param key Property key
     * @return Found property value
     */
    public String getSystemProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    /**
     * Set property
     *
     * @param key   Key to set
     * @param value Value to set
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }


    /**
     * Get properties
     *
     * @return All properties
     */
    public Map<String, String> getProperties() {
        HashMap<String, String> result = new HashMap<>();
        properties.forEach((key, value) -> result.put(String.valueOf(key), String.valueOf(value)));
        return result;
    }
}
